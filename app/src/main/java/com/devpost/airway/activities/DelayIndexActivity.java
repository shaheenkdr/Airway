package com.devpost.airway.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.devpost.airway.R;
import com.devpost.airway.api.ApiClient;
import com.devpost.airway.flightstats.s.apis.DelayApiInterface;
import com.devpost.airway.flightstats.s.apis.WeatherApiInterface;
import com.devpost.airway.flightstats.s.delay.DelayPojo;
import com.devpost.airway.flightstats.s.weather.WeatherPojo;
import com.devpost.airway.utility.Util;
import com.easyandroidanimations.library.FadeInAnimation;
import com.easyandroidanimations.library.FadeOutAnimation;
import com.easyandroidanimations.library.FlipHorizontalAnimation;
import com.easyandroidanimations.library.ParallelAnimator;
import com.easyandroidanimations.library.ScaleInAnimation;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DelayIndexActivity extends AppCompatActivity implements OnChartValueSelectedListener
{
    private PieChart mChart;
    private CardView card;
    private ImageView desc;
    private TextView mText;
    private List<PieMem> arr_values;
    private static final String URL = "https://api.flightstats.com/flex/delayindex/rest/v1/json/airports/LAX";
    private static final int classification = 1;
    private static final int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delay_index);
        mChart = (PieChart) findViewById(R.id.chart1);
        card = (CardView)findViewById(R.id.descCard);
        desc = (ImageView)findViewById(R.id.descMarker);
        mText = (TextView)findViewById(R.id.pie_desc_text);
        getDelayIndex();

    }

    private void getDelayIndex()
    {
        DelayApiInterface apiService = ApiClient.getClient().create(DelayApiInterface.class);

        Call<DelayPojo> call = apiService.getDelayValues(URL, Util.getAppId(),Util.getAppKey(),classification,score);
        call.enqueue(new Callback<DelayPojo>()
        {
            @Override
            public void onResponse(Call<DelayPojo>call, Response<DelayPojo> response)
            {
                String x = call.request().url().toString();
                if (response.isSuccessful())
                {
                    arr_values = new ArrayList<PieMem>();
                    arr_values.add(new PieMem(response.body().getDelayIndexes().get(0).getDelayed15(),"Flights delayed by 15 min"));
                    arr_values.add(new PieMem(response.body().getDelayIndexes().get(0).getDelayed30(),"Flights delayed by 30 min"));
                    arr_values.add(new PieMem(response.body().getDelayIndexes().get(0).getDelayed45(),"Flights delayed by 45 min"));
                    arr_values.add(new PieMem(response.body().getDelayIndexes().get(0).getOnTime(),"Flights in time"));
                    configureMChart();

                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(DelayIndexActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(DelayIndexActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<DelayPojo> call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE", t.toString());
                String ff = call.request().url().toString();
                Log.e("TWOING",ff);
            }
        });

    }
    private void configureMChart()
    {
        //mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        mChart.setExtraOffsets(5, 10, 5, 5);
        mChart.setDragDecelerationFrictionCoef(0.95f);

        mChart.setCenterText(generateCenterSpannableText());

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(ResourcesCompat.getColor(getResources(), R.color.back, null));

        mChart.setTransparentCircleColor(ResourcesCompat.getColor(getResources(), R.color.back, null));
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(5);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);
        mChart.setOnChartValueSelectedListener(this);

        setData(arr_values);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);


        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mChart.setEntryLabelColor(Color.WHITE);
        mChart.setDrawSliceText(false);
        mChart.setEntryLabelTextSize(12f);
    }

    private void setData(List<PieMem> arr)
    {



        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < arr.size() ; i++) {
            entries.add(new PieEntry(arr.get(i).getVal(),i));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Delay Index");
        dataSet.setSliceSpace(4f);
        dataSet.setSelectionShift(9f);


        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        //data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);

    }

    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("MPAndroidChart\ndeveloped by Philipp Jahoda");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 14, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.actionToggleValues: {
                for (IDataSet<?> set : mChart.getData().getDataSets())
                    set.setDrawValues(!set.isDrawValuesEnabled());

                mChart.invalidate();
                break;
            }
            case R.id.actionToggleHole: {
                if (mChart.isDrawHoleEnabled())
                    mChart.setDrawHoleEnabled(false);
                else
                    mChart.setDrawHoleEnabled(true);
                mChart.invalidate();
                break;
            }
            case R.id.actionDrawCenter: {
                if (mChart.isDrawCenterTextEnabled())
                    mChart.setDrawCenterText(false);
                else
                    mChart.setDrawCenterText(true);
                mChart.invalidate();
                break;
            }
            case R.id.actionToggleXVals: {

                mChart.setDrawEntryLabels(!mChart.isDrawEntryLabelsEnabled());
                mChart.invalidate();
                break;
            }
            case R.id.actionSave: {
                // mChart.saveToGallery("title"+System.currentTimeMillis());
                mChart.saveToPath("title" + System.currentTimeMillis(), "");
                break;
            }
            case R.id.actionTogglePercent:
                mChart.setUsePercentValues(!mChart.isUsePercentValuesEnabled());
                mChart.invalidate();
                break;
            case R.id.animateX: {
                mChart.animateX(1400);
                break;
            }
            case R.id.animateY: {
                mChart.animateY(1400);
                break;
            }
            case R.id.animateXY: {
                mChart.animateXY(1400, 1400);
                break;
            }
            case R.id.actionToggleSpin: {
                mChart.spin(1000, mChart.getRotationAngle(), mChart.getRotationAngle() + 360, Easing.EasingOption
                        .EaseInCubic);
                break;
            }
        }
        return true;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h)
    {
        int[] color = mChart.getData().getColors();
        desc.setBackgroundColor(color[((int)h.getX())]);
        mText.setText(arr_values.get((int)h.getX()).getDesc());

            new FadeInAnimation(card)
                    .setDuration(500)
                    .animate();

        if (e == null)
            return;
        Log.e("VAL SELECTED",
                "Value: " + e.getY() + ", index: " + h.getX()
                        + ", DataSet index: " + h.getDataSetIndex());
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }

    private class PieMem
    {
        private final int val;
        private final String desc;

        public PieMem(int val,String desc)
        {
            this.val = val;
            this.desc = desc;
        }

        public int getVal()
        {
            return val;
        }

        public String getDesc()
        {
            return desc;
        }
    }

}

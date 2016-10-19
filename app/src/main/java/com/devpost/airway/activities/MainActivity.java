package com.devpost.airway.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.devpost.airway.R;
import com.devpost.airway.actions.ActionStarter;
import com.devpost.airway.intents.Meditate;
import com.devpost.airway.utility.ResponseX;
import com.devpost.airway.utility.Text;
import com.devpost.airway.adapter.CustomAdapter;
import com.devpost.airway.api.ApiClient;
import com.devpost.airway.api.ApiInterface;
import com.devpost.airway.bus.LuisResponseBus;
import com.devpost.airway.intents.Booking;
import com.devpost.airway.intents.Food;
import com.devpost.airway.intents.Games;
import com.devpost.airway.intents.Greetings;
import com.devpost.airway.intents.Help;
import com.devpost.airway.intents.None;
import com.devpost.airway.intents.Personal;
import com.devpost.airway.intents.Places;
import com.devpost.airway.pojo.IntentX;
import com.devpost.airway.pojo.LuisPojo;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
{
    private ArrayList<Text> adapter_data;
    private RecyclerView chat_view;
    private CustomAdapter adapter;
    private Text test1;
    private Text test2;
    private Text test3;
    private Context mContext;
    private static int event_id;
    private static int response_code;
    private Intent intent;
    private static boolean flag;
    private static final String id ="44e80599-c74c-4bc7-b30e-41730a6adfb2";
    private static final String sub_key ="3c12c7fd5d4c408ab856288e695ee5f7";
    private static final int REQUEST_PHONE_CALL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"));

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
            }
            else
            {
                startActivity(intent);
            }
        }
        else
        {
            startActivity(intent);
        }


        EventBus myEventBus = EventBus.getDefault();
        EventBus.getDefault().register(this);
        event_id = response_code = -1;
        flag = false;
        test1 = new Text("Hello I am tom cruise",true);
        test2 = new Text("wow nice to meet",false);
        test3 = new Text("nice to meet you",true);
        adapter_data = new ArrayList<>();
        adapter_data.add(test1);
        adapter_data.add(test2);
        adapter_data.add(test3);
        chat_view = (RecyclerView)findViewById(R.id.chatView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        chat_view.setLayoutManager(llm);
        adapter = new CustomAdapter(adapter_data);
        chat_view.setAdapter(adapter);
        mContext = getApplicationContext();
        final EditText test = (EditText)findViewById(R.id.chat_input);
        test.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND)
                {
                    // TODO do something
                    handled = true;
                    doGetRequest(test.getText().toString().trim());
                    Log.e("WhileSending",""+test.getText().toString().trim());
                    adapter_data.add(new Text(test.getText().toString(),true));
                    adapter.notifyDataSetChanged();
                    chat_view.smoothScrollToPosition(adapter_data.size()-1);
                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);


                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    test.setText("");
                }
                return handled;
            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PHONE_CALL: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);
                }
                else
                {

                }
                return;
            }
        }
    }

    private  void doGetRequest(final String message)
    {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<LuisPojo> call = apiService.getValues(id,sub_key,message);
        call.enqueue(new Callback<LuisPojo>()
        {
            @Override
            public void onResponse(Call<LuisPojo>call, Response<LuisPojo> response)
            {
                try
                {
                    double temp = 0;
                    StringBuilder val = new StringBuilder();
                    Log.e("Thenga",""+response.body().toString());
                    List<IntentX> intx = response.body().getIntents();
                    Log.e("Intentx",""+intx.size());
                    for(IntentX x:intx)
                    {
                        Log.e("Intents",""+x.getIntent());
                        if(x.getScore()>temp)
                        {
                            temp = x.getScore();
                            val.setLength(0);
                            val.append(x.getIntent());
                        }
                    }
                    EventBus.getDefault().post(new LuisResponseBus(val.toString(),message));

                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Check data connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LuisPojo> call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE", t.toString());
            }
        });
    }

    @Subscribe
    public void onEvent(LuisResponseBus event)
    {
        responseProcessor(event);
    }

    private void responseProcessor(LuisResponseBus event)
    {
        ResponseX reply_msg = new ResponseX(0,"",99,false);
        if(flag)
        {
            if(event.getOriginalMessage().contains("yes")||event.getOriginalMessage().contains("ye")||event.getOriginalMessage().contains("yea")||event.getOriginalMessage().contains("yeah"))
            {
                if(getEventIdForIntent(event.getIntentName())==1)
                {
                    ActionStarter a1 = new ActionStarter(mContext,1);
                }

                if(getEventIdForIntent(event.getIntentName())==3)
                {
                    ActionStarter a1 = new ActionStarter(mContext,3);
                }
            }
            else
            {
                flag = false;
            }
        }
        else
        {
            if(getEventIdForIntent(event.getIntentName())!=8 && getEventIdForIntent(event.getIntentName())!=7 && getEventIdForIntent(event.getIntentName())!=4)
            {
                switch (getEventIdForIntent(event.getIntentName()))
                {
                    case 1: reply_msg = Booking.chooseBooking(event.getOriginalMessage());
                        break;
                    case 2: reply_msg = Food.chooseFood(event.getOriginalMessage());
                        break;
                    case 3: reply_msg = Games.chooseGames(event.getOriginalMessage());
                        break;
                    case 5: reply_msg = Help.chooseHelp();
                        break;
                    case 6: reply_msg = Meditate.chooseMeditate(event.getOriginalMessage());
                        break;
                    case 9: reply_msg = Places.choosePlace();
                        break;
                }
                flag = true;

            }
            else
            {
                switch (getEventIdForIntent(event.getIntentName()))
                {
                    case 8: reply_msg = Personal.choosePersonal(event.getOriginalMessage());
                        break;
                    case 7: reply_msg = None.chooseNone();
                        break;
                    case 4: reply_msg = Greetings.chooseGreetings(event.getOriginalMessage());
                        break;
                }
                flag = false;
            }
            adapter_data.add(new Text(reply_msg.getResponse(),false));
            adapter.notifyDataSetChanged();
            chat_view.smoothScrollToPosition(adapter_data.size()-1);
        }



    }


    private static int getEventIdForIntent(String value)
    {
        int ret_value;
        switch (value)
        {
            case "None": ret_value = 7;
                break;
            case "Food": ret_value = 2;
                break;
            case "Greetings": ret_value = 4;
                break;
            case "Booking": ret_value = 1;
                break;
            case "help": ret_value = 5;
                break;
            case "games": ret_value = 3;
                break;
            case "Personal": ret_value = 8;
                break;
            case "Places": ret_value = 9;
                break;
            case "Meditate": ret_value = 6;
                break;
            default: ret_value = -1;
                break;
        }

        return ret_value;

    }
}

package com.devpost.airway;

import android.content.Context;
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

import com.devpost.airway.bus.LuisResponseBus;
import com.devpost.airway.intents.Booking;
import com.devpost.airway.intents.Food;
import com.devpost.airway.intents.Games;
import com.devpost.airway.intents.Greetings;
import com.devpost.airway.intents.Help;
import com.devpost.airway.intents.None;
import com.devpost.airway.intents.Personal;
import com.devpost.airway.intents.Places;

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
    private static final String id ="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    private static final String sub_key ="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus myEventBus = EventBus.getDefault();
        EventBus.getDefault().register(this);
        //Intent ss = new Intent(MainActivity.this,TwoGameActivity.class);
        //startActivity(ss);
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
        String name = event.getIntentName();
        String result;

        switch (name)
        {
            case "None": result = None.chooseNone();
                break;
            case "Food": result = Food.chooseFood(event.getOriginalMessage());
                break;
            case "Greetings": result = Greetings.chooseGreetings(event.getOriginalMessage());
                break;
            case "Booking": result = Booking.chooseBooking(event.getOriginalMessage());
                break;
            case "help": result = Help.chooseHelp();
                break;
            case "games": result = Games.chooseGames(event.getOriginalMessage());
                break;
            case "Personal": result = Personal.choosePersonal(event.getOriginalMessage());
                break;
            case "Places": result = Places.choosePlace();
                break;
            default: result = "";
                break;
        }
        adapter_data.add(new Text(result,false));
        adapter.notifyDataSetChanged();
        chat_view.smoothScrollToPosition(adapter_data.size()-1);
    }
}

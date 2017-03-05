package mavl.com.kekekekekeke;

import android.support.v7.app.AppCompatActivity;

import ru.yandex.speechkit.Error;
import ru.yandex.speechkit.SpeechKit;
import ru.yandex.speechkit.Synthesis;
import ru.yandex.speechkit.Vocalizer;
import ru.yandex.speechkit.VocalizerListener;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements VocalizerListener {
    Vocalizer vocalizer;
    String s1;
    EditText ed;
    static final String API_KEY_YANDEX = "670655db-edd8-4ee5-b3b7-e9d47ec78ed8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SpeechKit.getInstance().configure(getApplicationContext(), API_KEY_YANDEX);
        ed = (EditText) findViewById(R.id.editText);
    }

    private void resetVocalizer() {
        if (vocalizer != null) {
            vocalizer.cancel();
            vocalizer = null;
        }
    }

    @Override
    public void onSynthesisBegin(Vocalizer vocalizer) {

    }

    @Override
    public void onSynthesisDone(Vocalizer vocalizer, Synthesis synthesis) {

    }

    @Override
    public void onPlayingBegin(Vocalizer vocalizer) {

    }

    @Override
    public void onPlayingDone(Vocalizer vocalizer) {

    }

    @Override
    public void onVocalizerError(Vocalizer vocalizer, Error error) {

    }
    public void playvoice(View view){
        s1 = ed.getText().toString();
        resetVocalizer();
        // To create a new vocalizer, specify the language, the text to be vocalized, the auto play parameter
        // and the voice.
        vocalizer = Vocalizer.createVocalizer(Vocalizer.Language.RUSSIAN, s1, true, Vocalizer.Voice.ERMIL);
        // Set the listener.
        vocalizer.setListener(this);
        // Don't forget to call start.
        vocalizer.start();
    }
}

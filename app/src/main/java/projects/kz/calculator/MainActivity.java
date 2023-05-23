package projects.kz.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnOshiru, btnNukte, btnPlusMinus;
    Button btnPlus, btnTen, btnMinus, btnX, btnBolu;
    TextView tvSan, tvZapis;

    String birinshiSan, ekinshiSan, znak, zapisText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnOshiru = findViewById(R.id.btnOshiru);
        btnNukte = findViewById(R.id.btnNukte);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);

        btnPlus = findViewById(R.id.btnPlus);
        btnTen = findViewById(R.id.btnTen);
        btnMinus = findViewById(R.id.btnMinus);
        btnX = findViewById(R.id.btnX);
        btnBolu = findViewById(R.id.btnBolu);

        tvSan = findViewById(R.id.tv_san);
        tvZapis = findViewById(R.id.tv_zapis);

        btn0.setOnClickListener(v -> {buttonClick(0);});
        btn1.setOnClickListener(v -> {buttonClick(1);});
        btn2.setOnClickListener(v -> {buttonClick(2);});
        btn3.setOnClickListener(v -> {buttonClick(3);});
        btn4.setOnClickListener(v -> {buttonClick(4);});
        btn5.setOnClickListener(v -> {buttonClick(5);});
        btn6.setOnClickListener(v -> {buttonClick(6);});
        btn7.setOnClickListener(v -> {buttonClick(7);});
        btn8.setOnClickListener(v -> {buttonClick(8);});
        btn9.setOnClickListener(v -> {buttonClick(9);});

        btnOshiru.setOnClickListener(v -> {buttonClick2('C');});
        btnNukte.setOnClickListener(v -> {buttonClick('.');});
        btnPlusMinus.setOnClickListener(v -> {buttonClick2('!');}); //PlusMinus

        btnPlus.setOnClickListener(v -> {buttonClick3('+');});
        btnTen.setOnClickListener(v -> {buttonClick4('=');});
        btnMinus.setOnClickListener(v -> {buttonClick5('-');});
        btnBolu.setOnClickListener(v -> {buttonClick7('/');});
        btnX.setOnClickListener(v -> {buttonClick6('x');});
    }

    public void buttonClick(int n) {
        String aldyngySan = tvSan.getText().toString();
        String basylganSan = "";
        String result = "";

        switch (n) {
            case 0:
                basylganSan = "0";
                break;
            case 1:
                basylganSan = "1";
                break;
            case 2:
                basylganSan = "2";
                break;
            case 3:
                basylganSan = "3";
                break;
            case 4:
                basylganSan = "4";
                break;
            case 5:
                basylganSan = "5";
                break;
            case 6:
                basylganSan = "6";
                break;
            case 7:
                basylganSan = "7";
                break;
            case 8:
                basylganSan = "8";
                break;
            case 9:
                basylganSan = "9";
                break;

            case '.':
                basylganSan = ".";
                break;
        }
        if (!aldyngySan.equals("0") || (aldyngySan.equals("0") && basylganSan.equals('.'))) result = aldyngySan + basylganSan;
        else result = basylganSan;
        tvSan.setText(result);
        }

        public void buttonClick2(int n) {
            switch (n) {
                case 'C':
                    tvSan.setText("0");
                    break;
                case '!':
                    String sanText = tvSan.getText().toString();
                    int san = Integer.parseInt(sanText);

                    if (san > 0) tvSan.setText("-" + sanText);

                    else {
                        san = san * (-1);
                        tvSan.setText("" + san);
                    }
                    break;
            }
        }

        public void buttonClick3(int n) {
            switch (n) {
                case '+':
                    birinshiSan = tvSan.getText().toString();

                    znak = "+";
                    zapisText = birinshiSan + znak;
                    tvZapis.setText(zapisText);
                    tvSan.setText("0");
            }
        }
        public void buttonClick6(int n) {
            switch (n) {
                case 'x':
                    birinshiSan = tvSan.getText().toString();

                    znak = "*";
                    zapisText = birinshiSan + znak;
                    tvZapis.setText(zapisText);
                    tvSan.setText("0");
            }
        }
        public void buttonClick5(int n) {
            switch (n) {
                case '-':
                    birinshiSan = tvSan.getText().toString();

                    znak = "-";
                    zapisText = birinshiSan + znak;
                    tvZapis.setText(zapisText);
                    tvSan.setText("0");
            }
        }
        public void buttonClick7(int n) {
            switch (n) {
                case '/':
                    birinshiSan = tvSan.getText().toString();

                    znak = "/";
                    zapisText = birinshiSan + znak;
                    tvZapis.setText(zapisText);
                    tvSan.setText("0");
            }
        }
        public void buttonClick4(int n) {
            switch (n) {
                case '=':
                    ekinshiSan = tvSan.getText().toString();
                    if (znak.equals("+")) {
                        int san1 = Integer.parseInt(birinshiSan);
                        int san2 = Integer.parseInt(ekinshiSan);

                        int res = san1 + san2;
                        zapisText = birinshiSan + znak + ekinshiSan + "=" + res;
                        tvZapis.setText(zapisText);
                        tvSan.setText(""+res);
                    }else if(znak.equals("-")) {
                        int san1 = Integer.parseInt(birinshiSan);
                        int san2 = Integer.parseInt(ekinshiSan);

                        int res = san1 - san2;
                        zapisText = birinshiSan + znak + ekinshiSan + "=" + res;
                        tvZapis.setText(zapisText);
                        tvSan.setText(""+res);
                    }else if(znak.equals("*")) {
                        int san1 = Integer.parseInt(birinshiSan);
                        int san2 = Integer.parseInt(ekinshiSan);

                        int res = san1 * san2;
                        zapisText = birinshiSan + znak + ekinshiSan + "=" + res;
                        tvZapis.setText(zapisText);
                        tvSan.setText(""+res);
                    }else if(znak.equals("/")) {
                        int san1 = Integer.parseInt(birinshiSan);
                        int san2 = Integer.parseInt(ekinshiSan);

                        int res = san1 / san2;
                        zapisText = birinshiSan + znak + ekinshiSan + "=" + res;
                        tvZapis.setText(zapisText);
                        tvSan.setText(""+res);
                    }
            }
        }





}


package com.example.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView tshirts, sports,female_dresses,sweather;
    private ImageView glasses,purses_bags,hats,shoess;
    private ImageView headphoness,laptops,watches,mobiles;

    private Button LogoutBtn, CheckOrdersBtn, maintainProductsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        LogoutBtn = (Button) findViewById(R.id.admin_logout_button);
        CheckOrdersBtn  = (Button) findViewById(R.id.check_order_btn);
        maintainProductsBtn  = (Button) findViewById(R.id.maintain_btn);

        maintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,  HomeActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);
            }
        });

        tshirts  = (ImageView) findViewById(R.id.t_shirts);
        sports  = (ImageView) findViewById(R.id.sports_t_shirts);
        female_dresses = (ImageView)findViewById(R.id.female_dresses);
        sweather = (ImageView)findViewById(R.id.sweathers);

        glasses = (ImageView)findViewById(R.id.glasses);
        purses_bags = (ImageView)findViewById(R.id.purses_bags_wallests);
        hats = (ImageView)findViewById(R.id.hats_caps);
        shoess = (ImageView)findViewById(R.id.shoes);

        headphoness = (ImageView)findViewById(R.id.headphones_handfree);
        laptops = (ImageView)findViewById(R.id.laptops_pc);
        watches = (ImageView)findViewById(R.id.watches);
        mobiles = (ImageView)findViewById(R.id.mobilephones);


        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this,MainActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);
            }
        });

        CheckOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminNewOrdersActivity.class);
                startActivity(intent);
            }
        });


        tshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","T-shirts");
                startActivity(intent);
            }
        });

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Sports T-Shirts");
                startActivity(intent);
            }
        });

        female_dresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Female dresses");
                startActivity(intent);
            }
        });


        sweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Sweathers");
                startActivity(intent);
            }
        });

        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Glasses");
                startActivity(intent);
            }
        });

        purses_bags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Purses bags");
                startActivity(intent);
            }
        });

        hats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Hats & Caps");
                startActivity(intent);
            }
        });

        shoess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Shoes");
                startActivity(intent);
            }
        });


        headphoness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Headphones");
                startActivity(intent);
            }
        });


        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Laptops");
                startActivity(intent);
            }
        });


        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Watches");
                startActivity(intent);
            }
        });


        mobiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","Mobile Phones");
                startActivity(intent);
            }
        });
    }
}

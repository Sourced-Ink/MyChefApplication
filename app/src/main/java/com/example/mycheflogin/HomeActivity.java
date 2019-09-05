package com.example.mycheflogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private ImageButton  fave, profile, home ;
    private Button search, category ;
  private BottomNavigationView menuhome;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_home);

        //refferencing the .java variables to the .XML variables
       // bottom navigation bar
       fave = findViewById(R.id.fave_homeBTN);
       profile = findViewById(R.id.profile_homeBTN);
       home = findViewById(R.id.home_homeBTN);
       search = findViewById(R.id.searchBTN);
        category = findViewById(R.id.categoryBTN);
        menuhome = findViewById(R.id.menu_Pers);
       search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

       // settingup the intents for the bottom navigation bar
       fave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intentFave = new Intent(HomeActivity.this, FavouritesActivity.class);
               startActivity(intentFave);
           }
       });
       profile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intentProfile = new Intent(HomeActivity.this, ProfilePage.class);
               startActivity(intentProfile);

           }
      });
       home.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intentHome = new Intent(HomeActivity.this, FavouritesActivity.class);
               startActivity(intentHome);

           }
       });

        menuhome.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.homeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(HomeActivity.this, HomeActivity.class);

                                        return false;
                                    }
                                });
                                break;

                            case R.id.accountItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(HomeActivity.this, PersonalActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.recipeItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(HomeActivity.this, FavouritesActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;

                            case R.id.helpItem:
                                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem menuItem) {
                                        Intent intent = new Intent(HomeActivity.this, HelpActivity.class);
                                        startActivity(intent);
                                        return true;
                                    }
                                });
                                break;
                        }
                        return true;
                    }
                }
        );

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.bottommenu, menu);
//        menuhome = menu;
//        return menuhome.hasVisibleItems();
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.homeItem:
//                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
//                        startActivity(intent);
//                        return true;
//                    }
//                });
//                return true;
//
//            case R.id.accountItem:
//                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        Intent intent = new Intent(HomeActivity.this, PersonalActivity.class);
//                        startActivity(intent);
//                        return true;
//                    }
//                });
//                return true;
//
//            case R.id.recipeItem:
//                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        Intent intent = new Intent(HomeActivity.this, FavouritesActivity.class);
//                        startActivity(intent);
//                        return true;
//                    }
//                });
//                return true;
//
//            case R.id.helpItem:
//                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        Intent intent = new Intent(HomeActivity.this, HelpActivity.class);
//                        startActivity(intent);
//                        return true;
//                    }
//                });
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


//
//    private void MenuButtons(){
//        menuhome.getItem(R.id.homeItem).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
//                startActivity(intent);
//                return true;
//            }
//        });
//
//        menuhome.getItem(R.id.accountItem).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Intent intent = new Intent(HomeActivity.this, PersonalActivity.class);
//                startActivity(intent);
//                return true;
//            }
//        });
//
//        menuhome.getItem(R.id.helpItem).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Intent intent = new Intent(HomeActivity.this, HelpActivity.class);
//                startActivity(intent);
//                return true;
//            }
//        });
//
//        menuhome.getItem(R.id.recipeItem).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Intent intent = new Intent(HomeActivity.this, FavouritesActivity.class);
//                startActivity(intent);
//                return true;
//            }
//        });
//
//    }
}

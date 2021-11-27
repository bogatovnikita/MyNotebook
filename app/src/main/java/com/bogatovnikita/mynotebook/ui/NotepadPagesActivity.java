package com.bogatovnikita.mynotebook.ui;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bogatovnikita.mynotebook.R;
import com.bogatovnikita.mynotebook.domain.NoteEntity;

public class NotepadPagesActivity extends AppCompatActivity implements NotepadPagesFragment.Contract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepad_list_activity);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            initNotepadListFragment();
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            initNotepadListFragmentLand();
        }
    }

    protected void initNotepadListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_notepad_list_container, new NotepadPagesFragment())
                .commit();
    }

    @Override
    public void openNewNote(NoteEntity item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_notepad_list_container, NotePageFragment.newInstance(item))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void openNewNoteLand(NoteEntity item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_notepad_list_container_two, NotePageFragment.newInstance(item))
                .addToBackStack(null)
                .commit();
    }

    protected void initNotepadListFragmentLand() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_notepad_list_container, new NotepadPagesFragment())
                .replace(R.id.fragment_notepad_list_container_two, new NotePageFragment())
                .commit();
    }

    public void openSettingsFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_notepad_list_container, new SettingsFragment())
                .addToBackStack(null)
                .commit();
    }

    public void openSettingsFragmentLand() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_notepad_list_container_two, new SettingsFragment())
                .addToBackStack(null)
                .commit();
    }

    public void openAboutApplicationFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_notepad_list_container, new AboutApplicationFragment())
                .addToBackStack(null)
                .commit();
    }

    public void openAboutApplicationFragmentLand() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_notepad_list_container_two, new AboutApplicationFragment())
                .addToBackStack(null)
                .commit();
    }

    public void closeApp() {
        new AlertDialog.Builder(this).setIcon(R.drawable.ic_baseline_exit_to_app_24)
                .setTitle(R.string.exit)
                .setMessage(R.string.are_you_sure)
                .setPositiveButton(R.string.yes, (dialogInterface, i) -> finishAndRemoveTask()).setNegativeButton(R.string.no, null).show();
    }

    @Override
    public void onBackPressed() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            int count = getSupportFragmentManager().getBackStackEntryCount();

            if (count == 0) {
                super.onBackPressed();
            } else {
                getSupportFragmentManager().popBackStack();
            }
        } else {
            closeApp();
        }
    }
}
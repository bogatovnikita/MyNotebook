package com.bogatovnikita.mynotebook.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.bogatovnikita.mynotebook.R;
import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.Repository;

public class NotePageFragment extends Fragment {
    Integer id;
    EditText titleEditText;
    EditText noteEditText;
    private static final String TITLE_TEXT = "TITLE_TEXT";
    private static final String NOTE_TEXT = "NOTE_TEXT";
    private static final String ID_NOTE = "ID_NOTE";
    Button saveNoteButton;
    public static final String CHANNEL_ID = "CHANNEL_ID";
    public static final int ID_NOTIFICATION = 24;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_page_screen, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Bundle args = getArguments();
        if (args != null) {
            ((Repository) getActivity().getApplication()).getRepo().deleteNotes(args.getInt(ID_NOTE));
        }
        super.onAttach(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleEditText = view.findViewById(R.id.title_edit_text);
        noteEditText = view.findViewById(R.id.note_edit_text);
        saveNoteButton = view.findViewById(R.id.save_note_button);

        Bundle args = getArguments();
        if (args != null) {
            String titleText = args.getString(TITLE_TEXT);
            String noteText = args.getString(NOTE_TEXT);
            titleEditText.setText(titleText);
            noteEditText.setText(noteText);
        }

        saveNoteButton.setOnClickListener(v -> {
            String title = titleEditText.getText().toString();
            String note = noteEditText.getText().toString();
            ((Repository) requireActivity().getApplication()).getRepo().createNotes(new NoteEntity(id, title, note));
            showNotification(title);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_notepad_list_container, new NotepadPagesFragment())
                        .remove(this)
                        .commit();

            } else {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_notepad_list_container, new NotepadPagesFragment())
                        .replace(R.id.fragment_notepad_list_container_two, new NotePageFragment())
                        .commit();
            }
        });
    }

    public static NotePageFragment newInstance(NoteEntity item) {
        NotePageFragment notePageFragment = new NotePageFragment();
        if (item != null) {
            Bundle bundle = new Bundle();
            bundle.putString(TITLE_TEXT, item.getTitle());
            bundle.putString(NOTE_TEXT, item.getNoteText());
            bundle.putInt(ID_NOTE, item.getId());
            notePageFragment.setArguments(bundle);
        }
        return notePageFragment;
    }

    private void showNotification(String title) {
        createNotificationChannel();

        Resources resources = getResources();
        String temp = String.format(resources.getString(R.string.add_new_note_notification), title);
        Notification notification = new NotificationCompat.Builder(requireActivity(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setContentTitle(temp)
                .build();
        NotificationManagerCompat.from(requireActivity()).notify(ID_NOTIFICATION, notification);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManagerCompat.from(requireActivity()).createNotificationChannel(
                    new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_HIGH)
            );
        }
    }
}

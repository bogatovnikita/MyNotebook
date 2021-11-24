package com.bogatovnikita.mynotebook.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bogatovnikita.mynotebook.R;
import com.bogatovnikita.mynotebook.domain.NoteEntity;
import com.bogatovnikita.mynotebook.domain.Repository;

public class NotepadPagesFragment extends Fragment {
    private Contract contract;
    private RecyclerView recyclerView;
    private final NotesAdapter adapter = new NotesAdapter();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Contract) {
            contract = (Contract) context;
        } else {
            throw new IllegalStateException("Activity must implement NotepadPagesFragment.Contract");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notepad_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        initRecyclerView();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.notes_list_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.new_note_menu) {
            contract.openNewNote(null);
        }

        if (item.getItemId() == R.id.setting_menu && getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            contract.openSettingsFragment();
        } else if (item.getItemId() == R.id.setting_menu) {
            contract.openSettingsFragmentLand();
        }

        if (item.getItemId() == R.id.about_application_menu && getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            contract.openAboutApplicationFragment();
        } else if (item.getItemId() == R.id.about_application_menu) {
            contract.openAboutApplicationFragmentLand();
        }
        return super.onOptionsItemSelected(item);
    }

    interface Contract {
        void openNewNote(NoteEntity item);

        void openNewNoteLand(NoteEntity item);

        void openSettingsFragment();

        void openSettingsFragmentLand();

        void openAboutApplicationFragment();

        void openAboutApplicationFragmentLand();
    }

    @Override
    public void onDestroy() {
        contract = null;
        super.onDestroy();
    }

    public void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager((Context) contract));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this::onItemClick);
        adapter.setData(((Repository) requireActivity().getApplication()).getRepo().getNotes());
    }

    private void onItemClick(NoteEntity item) {
        showContextMenu(item);
    }

    private void showContextMenu(NoteEntity item) {
        recyclerView.setOnCreateContextMenuListener((contextMenu, view, contextMenuInfo) -> {
            requireActivity().getMenuInflater().inflate(R.menu.popup_notes_list_menu, contextMenu);

            contextMenu.findItem(R.id.delete_note_popup_menu).setOnMenuItemClickListener(menuItem -> {
                dialogDeleteNoteScreen(item);
                return true;
            });

            contextMenu.findItem(R.id.change_note_popup_menu).setOnMenuItemClickListener(menuItem -> {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    contract.openNewNote(item);
                } else {
                    contract.openNewNoteLand(item);
                }
                return true;
            });
        });
        recyclerView.showContextMenu();
    }

    private void dialogDeleteNoteScreen(NoteEntity item) {
        String titleNameNote = item.getTitle() + "?";
        Resources resources = getResources();
        String temp = String.format(resources.getString(R.string.dialog_delete_note), titleNameNote);
        new AlertDialog.Builder(requireContext()).setIcon(R.drawable.ic_baseline_exit_to_app_24)
                .setTitle(R.string.delete_note)
                .setMessage(temp)
                .setPositiveButton(R.string.yes, (dialogInterface, i) -> {
                    ((Repository) requireActivity().getApplication()).getRepo().deleteNotes(item.getId());
                    adapter.setData(((Repository) requireActivity().getApplication()).getRepo().getNotes());
                }).setNegativeButton(R.string.no, null).show();
    }

}


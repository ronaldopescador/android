package br.com.autocontrolbrasil.autocontrolbrasil.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.autocontrolbrasil.autocontrolbrasil.R;
import br.com.autocontrolbrasil.autocontrolbrasil.model.dao.AbastecimentoDAO;

/**
 * Created by Ronaldo on 20/07/2015.
 */
public class ListaAbastecimentosAdapter extends CursorAdapter {

    private LayoutInflater inflater;

    private AbastecimentoDAO dao;

    public ListaAbastecimentosAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);

        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.dao = new AbastecimentoDAO(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View item = inflater.inflate(R.layout.layout_item_abastecimento, null);

        return item;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView lblKmAtual = (TextView) view.findViewById(R.id.lblKmAtual);

        String kmAtual = cursor.getString(cursor.getColumnIndex("km_atual"));
        lblKmAtual.setText(kmAtual);
    }
}
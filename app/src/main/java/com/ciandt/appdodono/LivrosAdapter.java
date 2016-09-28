package com.ciandt.appdodono;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciandt.appdodono.model.Livro;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jbosco on 28/09/2016.
 */
public class LivrosAdapter extends BaseAdapter {
    private List<Livro> livros;
    private Context context;

    public LivrosAdapter(List<Livro> livros, Context context) {
        this.livros = livros;
        this.context = context;
    }

    @Override
    public int getCount() {
        return livros.size();
    }

    @Override
    public Object getItem(int position) {
        return livros.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.linha_livro, null);

        Livro livro = livros.get(position);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewLinhaLivroCapa);
        TextView textViewTitulo = (TextView) view.findViewById(R.id.textViewLinhaLivroTitulo);
        TextView textViewAutor = (TextView) view.findViewById(R.id.textViewLinhaLivroAutor);

        if (livro.getVolumeInfo().getImageLinks() != null) {
            Picasso.with(context).load(livro.getVolumeInfo().getImageLinks().getThumbnail()).into(imageView);
        }

        textViewTitulo.setText(livro.getVolumeInfo().getTitle());

        if (livro.getVolumeInfo().getAuthors() != null && !livro.getVolumeInfo().getAuthors().isEmpty()) {
            textViewAutor.setText(livro.getVolumeInfo().getAuthors().get(0));
        }

        return view;
    }
}

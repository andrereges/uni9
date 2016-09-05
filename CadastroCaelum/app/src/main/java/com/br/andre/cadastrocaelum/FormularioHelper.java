package com.br.andre.cadastrocaelum;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

/**
 * Created by andre on 03/09/16.
 */
public class FormularioHelper {

    private EditText editNome, editSite, editTelefone,editEndereco;
    private RatingBar ratingNota;
    private ImageView foto;
    private Aluno aluno;

    public FormularioHelper(Formulario formulario){


         editNome =     (EditText) formulario.findViewById(R.id.nome);
         editSite =     (EditText) formulario.findViewById(R.id.site);
         editTelefone = (EditText) formulario.findViewById(R.id.telefone);
         editEndereco = (EditText) formulario.findViewById(R.id.endereco);
         ratingNota =   (RatingBar) formulario.findViewById(R.id.nota);
         foto =         (ImageView)formulario.findViewById(R.id.foto);
         aluno =         new Aluno();

    }

    public Aluno pegaAlunoDoFormulario(){

        aluno.setNome(editNome.getText().toString());
        aluno.setSite(editSite.getText().toString());
        aluno.setEndereco(editEndereco.getText().toString());
        aluno.setTelefone(editTelefone.getText().toString());
        aluno.setNota(Double.valueOf(ratingNota.getRating()));

        return aluno;
    }


    public void colocaAlunoNoFormulario(Aluno alunoParaSerAlterado) {
       //Funciona como o oposto do metodo pegaAlunoDoFormulario
        aluno = alunoParaSerAlterado;
        editNome.setText(alunoParaSerAlterado.getNome());
        editSite.setText(alunoParaSerAlterado.getSite());
        editTelefone.setText(alunoParaSerAlterado.getTelefone());
        editEndereco.setText(alunoParaSerAlterado.getEndereco());
        ratingNota.setRating((float) alunoParaSerAlterado.getNota());

        if (aluno.getFoto() != null) {
            carregaImagem(alunoParaSerAlterado.getFoto());
        }
    }

    public ImageView getFoto() {
        return foto;
    }

    public void carregaImagem(String caminhoArquivo) {
        aluno.setFoto(caminhoArquivo);
        Bitmap imagem = BitmapFactory.decodeFile(caminhoArquivo);
        Bitmap imagemReduzida = Bitmap.createScaledBitmap(imagem, 300,300,true);

        foto.setImageBitmap(imagemReduzida);
    }
}

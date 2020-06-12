package com.permana.football.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.permana.football.API.APIRequestData;
import com.permana.football.API.RetroServer;
import com.permana.football.Activity.DetailPemainActivity;
import com.permana.football.Activity.MainActivity;
import com.permana.football.Activity.PemainActivity;
import com.permana.football.Activity.PemainFragment;
import com.permana.football.Activity.TambahActivity;
import com.permana.football.Model.DataModel;
import com.permana.football.Model.ResponseModel;
import com.permana.football.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataModel> listPemain;
    private int idPemain;


    public AdapterData(Context ctx, List<DataModel> listPemain) {
        this.ctx = ctx;
        this.listPemain = listPemain;


    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holder = new HolderData(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listPemain.get(position);


        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvNama.setText(dm.getNama());
        holder.tvPosisi.setText(dm.getPosisi());

    }

    @Override
    public int getItemCount() {
        return listPemain.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvId, tvNama, tvPosisi;
        ImageButton delete;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvPosisi = itemView.findViewById(R.id.tv_posisi);
            delete = itemView.findViewById(R.id.btn_delete);


            // CardView Pindah Detail Pemain
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Intent intent = new Intent(ctx, DetailPemainActivity.class);
                  ctx.startActivity(intent);


                }
            });


            //Button Delete
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteData();
                }
            });


// Fungsi Tekan Lama
//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
//                    dialogPesan.setMessage("Pilih Operasi yang akan Dilakukan");
//                    dialogPesan.setCancelable(true);
//
//                    idPemain = Integer.parseInt(tvId.getText().toString());
//
//                    dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            deleteData();
//                            dialog.dismiss();
//
//                            ((PemainActivity)ctx).retrieveData();
//                        }
//                    });
//
//                    dialogPesan.setNegativeButton("Ubah", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    });
//
//                    dialogPesan.show();
//
//                    return false;
//                }
//            });
        }

        //Delete Data
        private void deleteData(){

            idPemain = Integer.parseInt(tvId.getText().toString());

            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> hapusData = ardData.ardDeleteData(idPemain);



            hapusData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode = response.body().getKode();
                    String pesan = response.body().getPesan();

                    Toast.makeText(ctx, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Menghubungi Server"+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}

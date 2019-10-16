package com.example.kelaspaklis4ifelse;

public class HitungNilaiAkhir {

    public Double hitungnilaiakhir(double absen, double
            tugas, double uts, double uas){
        Double nilaiakhir=
                (absen*0.1)+(tugas*0.2)+(uts*0.3)+(uas*0.4);
        return nilaiakhir;
    }
}


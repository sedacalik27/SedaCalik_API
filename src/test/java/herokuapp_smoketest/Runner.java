package herokuapp_smoketest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TC01_CreateBooking.class,
                TC02_GetBooking.class,
                TC03_UpdateBooking.class,
                TC04_PartialUpdateBooking.class
        }
)
public class Runner {

}




/*
//14 Ekim
/*
* Post işleminde oluşturduğumuz datanın ID'sini aldık.
* jsonPath kullanarak bookingId değişkeninde ID değerimizi aldık
* Daha sonra bu değeri get,update,patchupdate de kullandık
* Id'yi aldık containeri koyduk
* Runner class kullandık. Çünkü manuel olarak çalıştırınca datalar bellekten siler. Sıfırlanmaması için hafızada yer koruması lazım
* Runner'dan çalıştırınca bütün testler sona erdikten sonra konsolda en aşağıda finish yazar.
* partialUpdate'de Mapleri kullanmanın daha avantajlı olduğunu gördük
* */

import java.util.*;

public class SansliNumaralarBulma {
    public static void main(String[] args) {

        Random random = new Random();

        Map<Integer, Integer> sayiMap = new HashMap<>();
        // 1. Rastgele Sayılar Üretme
        for (int i = 0; i < 10000; i++) {
            int sayi = random.nextInt(100) + 1;
            sayiMap.computeIfAbsent(sayi, k -> 0);
            sayiMap.put(sayi, sayiMap.get(sayi) + 1);
        }

        System.out.println("Üretilen sayılar ve tekrar sayıları:");
        sayiMap.forEach((key, value) -> System.out.println("Sayı: " + key + " - Tekrar Sayısı: " + value));

        // 2. Liste Oluşturma
        List<Integer> sayiListesi = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sayiMap.entrySet()) {
            Integer sayi = entry.getKey();
            Integer count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sayiListesi.add(sayi);
            }
        }

        Set<Integer> sansliSayi = new HashSet<>();

        // 3. Şanslı Numaraları Bulma
        while (sansliSayi.size() < 10 && !sayiListesi.isEmpty()) {
            Integer rastgeleSayi = sayiListesi.get(random.nextInt(sayiListesi.size()));
            sansliSayi.add(rastgeleSayi);
        }

        System.out.println("\nŞanslı Numaralar : ");
        sansliSayi.forEach(System.out::println);

        //4. Şanslı Numaralar Üzerinde İşlemler
        List<Integer> ellidenBuyuk = sansliSayi.stream()
                .filter(num -> num > 50)
                .toList();

        int toplam = sansliSayi.stream()
                .reduce(0, Integer::sum);

        int elliToplami = ellidenBuyuk.stream()
                .reduce(0, Integer::sum);

        System.out.println("\n50'den büyük şanslı numaralar:");
        ellidenBuyuk.forEach(System.out::println);

        System.out.println("\nTüm şanslı numaraların toplamı: " + toplam);
        System.out.println("\n50'den büyük şanslı numaraların toplamı: " + elliToplami);

    }
}

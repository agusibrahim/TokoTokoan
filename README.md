# TokoTokoan
by Agus Ibrahim

Desain Aplikasi terinspirasi dari 3 App E-Commerce terkenal di Indonesia, yaitu [Tokopedia](https://play.google.com/store/apps/details?id=com.tokopedia.tkpd), [Blanja](https://play.google.com/store/apps/details?id=com.blanja.apps.android), dan [Bukalapak](https://play.google.com/store/apps/details?id=com.bukalapak.android). Saya jadikan satu, karena desain ketiganya bagus-bagus.
![image](/storage/emulated/0/Pictures/PicsArt/PicsArt_03-30-11.08.06.jpg)
> Tokopedia, Blanja dan Bukalapak

## NO DECOMPILATION / REVERSE ENGINEERING PROCESS
Tidak ada proses decom APK, tidak ada intip-intip xml/java/smali, murni coding sendiri. Namun untuk ikon serta kategorinya saya ambil dari cache Aplikasi Tokopedia.

Dari Tokopedia saya ambil desain Kategorinya, icon serta penataan yang rapih. Untuk item Produk saya ambil dari Blanja, flat dan jelas. Dan dari Bukalapak, saya ambil ListView horizontal, yaa mirip-mirip Google Play Store lah saya suka.

## Seperti Apa Jadinya?
![image](/storage/emulated/0/Pictures/Screenshots/Screenshot_20170330-105550.png)

![image](/storage/emulated/0/Pictures/Screenshots/Screenshot_20170330-105609.png)

![image](/storage/emulated/0/Pictures/Screenshots/Screenshot_20170330-113038.png)

Mengambil tema warna hijau, Aplikasi yang saya namai "TokoTokoan" ini sekilas mirip dengan Tokopedia, karena disamping warna hijaunya, Kategori beserta ikonnya saya ambil dari Tokopedia.

## BEHIND THE SCENE
Layout parent/root menggunakan CoordinatorLayout, sedangkan bodi aplikasi menggunakan NestedScrollView LinearLayout vertikal karena disini kita menempatkan beberapa bagian View, seperti kategori A, kategori B, dsb sehingga membutuhkan scroll. 
Untuk item dalam kategori saya menggunakan RecyclerView gaya Grid (GridLayoutManager) 2 kolom.
RecyclerView juga diterapkan pada Scroll Horizontal produk (LinearLayoutManager orientasi Horizontal)

![image](/storage/emulated/0/Pictures/Screenshots/Screenshot_20170330-114311.png)

![image](/storage/emulated/0/Pictures/Screenshots/Screenshot_20170330-114152.png)

O iya, Coding/Build langsung di Android menggunakan AIDE

## BUG
Di beberapa device masih kurang pas, terutama device berDpi kecil. Ikon serta teks membesar, item produk kepotong. 

## Reference
* [Tokopedia](https://play.google.com/store/apps/details?id=com.tokopedia.tkpd)
* [Blanja](https://play.google.com/store/apps/details?id=com.blanja.apps.android)
* [Bukalapak](https://play.google.com/store/apps/details?id=com.bukalapak.android)
* [AIDE](https://play.google.com/store/apps/details?id=com.aide.ui)
* [Android Smart Image View](http://loopj.com/android-smart-image-view/)



## Help and Support
Contact: [Agus Ibrahim](http://fb.me/mynameisagoes)

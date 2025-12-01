
**Nama:** Vania Rahel Putri Widiyanto
**NIM:** 2481016
**Kelas:** TI
**Mata Kuliah:** Pemrograman Berorientasi Objek

## Catatan Pembelajaran
1. Interface Segregation Principle (ISP): Pecah interface besar menjadi interface kecil yang spesifik (fokus pada kapabilitas) agar kelas (klien) tidak dipaksa bergantung pada fungsionalitas yang tidak mereka gunakan.
2. Dependency Inversion Principle (DIP): Modul tingkat tinggi (PaymentService) harus bergantung pada abstraksi (interfaces), bukan pada implementasi konkret (StripePaymentGateway), untuk mencapai loose coupling. 
3. Pengujian & Fleksibilitas: Dengan bergantung pada abstraksi dan menggunakan Dependency Injection, kode menjadi sangat fleksibel dan mudah diuji, memungkinkan penggantian implementasi (misalnya, dari Stripe ke PayPal) tanpa mengubah logika inti.
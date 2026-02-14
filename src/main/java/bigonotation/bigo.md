# Big O Notation

- describes the performance of and algorithm as the amount of data increases.
- machine independent
- ignore smaller operations

Bir algoritmanın ne kadar hızlı olduğunu değil, veri miktarı arttıkça o algoritmanın ne kadar yorduğunu ölçen evrensel bir dildir.

BU ALGORİTMA ASLA BUNDAN DAHA YAVAŞ ÇALIŞMAZ.
## En sık karşılaşılan Karmaşıklıklar.
 
- O(1) - constant time -> vier sayısı ister 1 olsun ister 1 milyar, işlem süresi hiç değişmez. ÖRNEK: bir arrayliste
indexi belli olan bir elemanı getirmek get(5)
- O(logn) - logarithmic time -> veri sayısı her seferinde yarıya iner. çok verimlidir. ÖRNEK: binary search
- O(n) - Linear time -> veri sayısı ne kadar artarsa, işlem sayısı da o kadar artar. ÖRNEK: bir dizideki tüm elemanları
ekrana basan bir for döngüsü
- O(n^2) - quadratic time -> veri sayısı arttıkça işlem yükü karesi oranında artar. ÖRNEK: iç içe iki for döngüsü
- O(2^n) - Exponential time -> veri bir arttığında işlem iki katına çıkar. en kaçınılması gereken yapıdır.
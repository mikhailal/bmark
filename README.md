# Описание происходящего
Это тестовый проект для сравнения производительности replace, replaceAll и алгоритма замены, написанного на StringBuilder'e

# Из чего состоит
Это тестовый проект, содержащий в себе юнит-тесты и бенчмарки, сделанные на JMH

# Как запустить тестирование
Достаточно запустить test.sh из консоли

# Что показало профилирование
Тестирование выполнялось на OpenJDK11. Результаты такие:

java11-replace-allsubstituted          avgt   1375,647 ±  97,444      ns/op

java11-replace-different               avgt   995,523 ±  61,173      ns/op

java11-replaceall-allsubstituted       avgt   4394,794 ± 248,485      ns/op

java11-replaceall-different            avgt   3619,651 ± 209,997      ns/op

java11-replacesbuilder-allsubstituted  avgt   498,574 ±  30,380      ns/op

java11-replacesbuilder-different       avgt   703,331 ±  43,043      ns/op


Тесты, маркированные allsubstituted - показывают случай, где все символы заменяются, different - обычный кейс - что-то заменяется, что-то нет. 

# Выводы
Из этого можно сделать вывод, что в контексте OpenJDK11 replace работает действительно оптимальнее replaceAll, а метод, основанный на использовании StringBuilder - еще быстрее

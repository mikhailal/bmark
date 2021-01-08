# Описание происходящего
Это тестовый проект для сравнения производительности replace, replaceAll и алгоритма замены, написанного на StringBuilder'e

# Из чего состоит
Это тестовый проект, содержащий в себе юнит-тесты и бенчмарки, сделанные на JMH

# Как запустить тестирование
Достаточно запустить test.sh из консоли

# Что показало профилирование
Тестирование выполнялось на OpenJDK11. Результаты такие:

java11-replace-allsubstituted          avgt   1321,456 ±   12,509  ns/op

java11-replace-different               avgt   977,638 ±   70,506  ns/op

java11-replaceall-allsubstituted       avgt   4969,148 ± 1058,186  ns/op

java11-replaceall-different            avgt   3816,780 ±  683,875  ns/op

java11-replacesbuilder-allsubstituted  avgt   208,242 ±   13,835  ns/op

java11-replacesbuilder-different       avgt   308,688 ±   19,813  ns/op


Тесты, маркированные allsubstituted - показывают случай, где все символы заменяются, different - обычный кейс - что-то заменяется, что-то нет. 

# Выводы
Из этого можно сделать вывод, что в контексте OpenJDK11 replace работает действительно оптимальнее replaceAll, а метод, основанный на использовании StringBuilder - еще быстрее

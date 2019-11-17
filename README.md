### 原题

Problem Three: Merchant's Guide to the Galaxy
 
You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).
 
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
 
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.
 
Roman numerals are based on seven symbols:
 
Symbol

Value

I

1

V

5

X

10

L

50

C

100

D

500

M

1,000

 
Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.
 
The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
Only one small-value symbol may be subtracted from any large-value symbol.
A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.
(Source: Wikipedia ( [17]http://en.wikipedia.org/wiki/Roman_numerals)
 
Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.
 
You are expected to handle invalid queries appropriately.
 
Test input:
glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
 
Test Output:
pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about

### 题目分析
将输入的文本行进行拆分，提取四种关键指令
* 罗马货币别名指令
* 多个罗马货币兑换商品指令
* 多个罗马货币兑换指令
* 商品总价值指令

罗马数字转换十进制如下：
    
|  Symbol   | Value  |
|  ----  | ----  |
| I  | 1 |
| V  | 5 |
| X  | 10 |
| L  | 50 |
| C  | 100 |
| D  | 500 |
| M  | 1000 |
### 设计思路

针对每种指令创建一种策略，进行相应指令匹配，一旦指令匹配成功，则调用执行器执行相应的逻辑处理，匹配不成功则为无效指令。

执行器，功能包括指令逻辑执行、结果输出。

计算器，执行器里调用计算器进行数值转换及计算，计算结果返回给执行器。

### 执行操作
    cd ./liyan-galaxy-java
    mvn clean install -Dmaven.test.skip=true
    cd target
    java -jar liyan-galaxy-java-1.0-SNAPSHOT.jar



package com.poland;

//import static java.lang.Float.parseFloat;
import static java.lang.Math.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class Scan {

    public static final String incorrect = "incorrect input!"; // чтобы каждый раз не писать строку
    private LinkedList<String> expression = new LinkedList<String>(); // основной список, в который
    private LinkedList<Character> operands = new LinkedList<Character>();
    private LinkedList<Double> calculateStack = new LinkedList<Double>();
    private String[] strSplit;
    public LinkedList<String> getExpression() {
        return expression;
    }
    public LinkedList<Double> getCalculateStackalculate() {
        return calculateStack;
    }


    public void scan(String s){ // метод принимает введенную стоку

        this.strSplit = s.split(""); // далее строка нарезается
                                                // в массив strSplit поэлементно
    }

    public int priority(char ch){     // таблица приорита операций
        switch(ch) {
            case '(': return 1;
            case '+': case '-': return 2;
            case '*': case '/': return 3;
            case '^': return 4;
            default: return 0;
        }
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String calculated(){
        double f;
        double num2;
        for (String str: expression) {

            if (isDouble(str) || Objects.equals(str, "0")) {
                f = Double.parseDouble(str);
                calculateStack.addFirst(f);
            }else{
                if(Objects.equals(str, "+"))
                    calculateStack.addFirst(calculateStack.pollFirst() + calculateStack.pollFirst());
                else if(Objects.equals(str, "*"))
                    calculateStack.addFirst(calculateStack.pollFirst() * calculateStack.pollFirst());
                else if(Objects.equals(str, "-")){
                    num2 = calculateStack.pollFirst();
                    calculateStack.addFirst(calculateStack.pollFirst() - num2);
                }else if(Objects.equals(str, "/")){
                    num2 = calculateStack.pollFirst();
                    if(num2 != 0.0) calculateStack.addFirst(calculateStack.pollFirst() / num2);
                    else return incorrect;
                }else if(Objects.equals(str, "^"))
                    calculateStack.addFirst(pow(calculateStack.pollFirst(), calculateStack.pollFirst()));
                else return incorrect;
            }
        }
        return "win";
    }

    public String convert(){

        String str = "",  // возвращаемая строка метода
               bigNum;       // вспомогательная строка для записи цифр
                             // если на входе число больше одного знака

        boolean wasOperation = false,       // флаг на операции (*, -, +, /)
                wasNum = false,             // флаг на цифры, чтобы отличать от чисел
                wasDot = false,             // флаг на дробное число
                closeBrackets = false;      // флаг на закрытую скобку

        int brackets = 0,                 // флаг на кол-во скобок
            index = 0,                   // индекс элемента строки
            LENGTH = strSplit.length;      // длина строки
        char CHAR = strSplit[index].charAt(index); // элемент введенной строки

        if((!Character.isDigit(CHAR) && (CHAR != '(')))
            return incorrect; // проверка на корректность первого элемента

        for (String s: strSplit) { // начинаем проверять каждый элемент по очереди

            CHAR = s.charAt(0);

            if(Character.isDigit(CHAR) || Objects.equals(CHAR, '.')) { // если наш элемент цифра, то:
                if (closeBrackets ||  // после закрывающейся скобки не может идти число или точка
                   (Objects.equals(CHAR, '.') && wasOperation)) // после операцией не может идти точка
                    return incorrect;
                if (Objects.equals(CHAR, '.') && index > 0) //  после открывающей скобки не может идти точка
                    if (Objects.equals(CHAR, '.') && Objects.equals(strSplit[index-1].charAt(0), '('))
                        return incorrect;
                if (wasNum || wasDot) {  // проверяем флаг на предыдущий элемент, если он был цифрой, то:
                    bigNum = expression.pollLast();  // записываем в NUM последний элемент из стека
                    bigNum += String.valueOf(CHAR); // добовляем к нему текущую цифру
                    expression.add(bigNum); // и пушим получившееся число обратно в стек
                } else expression.add(String.valueOf(CHAR));


                if(Objects.equals(CHAR, '.')){
                    wasDot = true; wasNum = false; // меняем флаги
                    wasOperation = false; closeBrackets = false;
                } else {
                    wasDot = false; wasNum = true;  // меняем флаги
                    wasOperation = false; closeBrackets = false;
                }
            }else{ // если наш элемент не цифра, то:

                switch(CHAR){

                    case '(':
                        if(wasNum || closeBrackets) return incorrect; // открывать скобку перед числом или закрывающей скобки нельзя
                        operands.addLast(CHAR); // заносим скобку в стек операций
                        ++brackets ;
                        wasOperation = false; wasNum = false; // меняем флаги
                        closeBrackets = false; wasDot = false;
                        break;

                    case '+': case '-': case '*': case '/': case '^':
                        if(index == LENGTH) return incorrect; // строка не может оканчиваться знаком операции

                        if(!wasOperation){
                            wasOperation = true; wasNum = false; // меняем флаги
                            closeBrackets = false; wasDot = false;

                            if(operands.isEmpty() || priority(CHAR) > priority(operands.getLast())){  // если operands пуст или операции в нем
                                operands.addLast(CHAR);   // по приоритету ниже текущего символа, то закидываем эту операцию на верх operands
                            }else {
                               for(int t = 0; t < operands.size(); t++)
                                   if(priority(CHAR) <= priority(operands.getLast()))  //  если последний внесенный символ имеет приоритет
                                        expression.addLast(String.valueOf(operands.pollLast())); //  больший или равный приоритету текущего
//                                 // символа, то извлекаем операции из operands в expression до тех пор, пока выполняется это условие
                               operands.addLast(CHAR);
                            }

                        }else return incorrect;  // операции не могут идти подряд
                        break;

                    case ')':
                        if(wasOperation || wasDot) return "incorrect input";  // перед закрывающей скобкой не может стоять операций
                        else                                                   // и скобки не могут быть пустыми
                            while((CHAR = operands.pollLast()) != '(' && brackets > 0) // выталкиваем все операции до открывающейся скобки в expression
                                expression.addLast(String.valueOf(CHAR));

                        --brackets;
                        wasNum = false; closeBrackets = true; // меняем флаги
                        wasDot = false; wasOperation = false;
                        break;

                    default: return incorrect; // на вход могут поступать только цифры и знаки
                }
            }
            index++;
//            CHAR = strSplit[index].charAt(index);
        }

        while(operands.size() != 0){
            expression.add(String.valueOf(operands.pollLast()));  /// заполнение стека остатками операций
        }

        for(int i = 0; i < expression.size(); i++){
            str += expression.get(i);                // переносим из expression всю польскую запись в строку
            str += "  ";                         // разделитель для удобства
        }

        return str;
    }
    public void ClearStacks(){
        expression.clear();
        operands.clear();
        calculateStack.clear();
    }

}

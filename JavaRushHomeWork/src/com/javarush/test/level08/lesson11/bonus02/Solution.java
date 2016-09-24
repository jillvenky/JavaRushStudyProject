package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        HashMap<String, String> addresses = new HashMap<String, String>();
        //List<String> addresses = new ArrayList<String>();
        while (true)
        {
            String address = reader.readLine();

            if (address.isEmpty()) break;
            else
                {
                    String family = reader.readLine();
                    addresses.put(address, family);
                }
        }

        //read home number
        String findByAddress = reader.readLine();

        if (!findByAddress.isEmpty())
        {
            for (Map.Entry<String, String> item:
                 addresses.entrySet())
            {
                if(item.getKey().equals(findByAddress))
                {
                    System.out.println(item.getValue());
                }
            }
        }
    }
}

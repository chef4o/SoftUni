using System;

namespace CalcOperations
{
    class Program
    {
        static void Main(string[] args)
        {
            int n1 = int.Parse(Console.ReadLine());
            int n2 = int.Parse(Console.ReadLine());
            string oper = Console.ReadLine();

            double result = 0;
            string evenOrOdd = string.Empty;
            string endResult = string.Empty;

            switch (oper)
            {
                case "+":
                    result = n1 + n2;
                    break;
                case "-":
                    result = n1 - n2;
                    break;
                case "*":
                    result = n1 * n2;
                    break;
                case "/":
                    if (n2 != 0)
                    {
                        result = 1.0 * n1 / n2;
                    }
                    break;
                case "%":
                    if (n2 != 0)
                    {
                        result = n1 % n2;
                    }
                    break;
            }

            if (result % 2 == 0)
            {
                evenOrOdd = "even";
            }
            else
            {
                evenOrOdd = "odd";
            }

            if (oper == "+" || oper == "-" || oper == "*")
            {
                endResult = $"{n1} {oper} {n2} = {result} - {evenOrOdd}";
            }
            else if ((oper == "/" || oper == "%") && n2 == 0)
            {
                endResult = $"Cannot divide {n1} by zero";
            }
            else if (oper == "/" && n2 != 0)
            {
                endResult = $"{n1} / {n2} = {result:f2}";
            }
            else if (oper == "%")
            {
                endResult = $"{n1} % {n2} = {result}";
            }

            Console.WriteLine(endResult);

        }
    }
}

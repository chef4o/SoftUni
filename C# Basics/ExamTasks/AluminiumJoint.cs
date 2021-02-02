using System;
using System.Xml.Schema;

namespace Task3
{
    class Program
    {
        static void Main(string[] args)
        {
            int joinCount = int.Parse(Console.ReadLine());
            if (joinCount > 10)
            {
                string joinType = Console.ReadLine();
                string delivery = Console.ReadLine();

                double singlePrice = 0;

                switch (joinType)
                {
                    case "90X130":
                        singlePrice = 110;
                        if (joinCount > 30 && joinCount <= 60)
                        {
                            singlePrice *= (1 - 5.0 / 100);
                        }
                        else if (joinCount > 60)
                        {
                            singlePrice *= (1 - 8.0 / 100);
                        }
                        break;
                    case "100X150":
                        singlePrice = 140;
                        if (joinCount > 40 && joinCount <= 80)
                        {
                            singlePrice *= (1 - 6.0 / 100);
                        }
                        else if (joinCount > 80)
                        {
                            singlePrice *= (1 - 10.0 / 100);
                        }
                        break;
                    case "130X180":
                        singlePrice = 190;
                        if (joinCount > 20 && joinCount <= 50)
                        {
                            singlePrice *= (1 - 7.0 / 100);
                        }
                        else if (joinCount > 50)
                        {
                            singlePrice *= (1 - 12.0 / 100);
                        }
                        break;
                    case "200X300":
                        singlePrice = 250;
                        if (joinCount > 25 && joinCount <= 50)
                        {
                            singlePrice *= (1 - 9.0 / 100);
                        }
                        else if (joinCount > 50)
                        {
                            singlePrice *= (1 - 14.0 / 100);
                        }
                        break;
                }

                double totalPrice = singlePrice * joinCount;

                if (delivery == "With delivery")
                {
                    totalPrice += 60;
                }

                if (joinCount > 99)
                {
                    totalPrice *= (1 - 4.0 / 100);
                }

                Console.WriteLine($"{totalPrice:f2} BGN");

            }
            else
            {
                Console.WriteLine("Invalid order");
            }
        }
    }
}

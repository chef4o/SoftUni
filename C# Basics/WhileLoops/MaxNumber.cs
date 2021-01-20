    using System;

    namespace MaxNumber
    {
        class Program
        {
            static void Main(string[] args)
            {
                int max = int.MinValue;

                while (true)
                {

                    string input = Console.ReadLine();

                    if (input != "Stop")
                    {
                        int n = Convert.ToInt32(input);
                        if (n > max)
                        {
                            max = n;
                        }
                    }
                    else
                    {
                        Console.WriteLine(max);
                        break;
                    }
                }
            }
        }
    }

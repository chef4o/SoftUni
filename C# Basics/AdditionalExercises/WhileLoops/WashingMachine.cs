using System;

namespace WhileCycle__
{
    class Program
    {
        static void Main(string[] args)
        {
            int detergent = int.Parse(Console.ReadLine()) * 750;

            int detergentUsed = 0;
            int dishesCount = 0;
            int potsCount = 0;
            int load = 0;
            string output = string.Empty;

            string dishes = Console.ReadLine();
            while (dishes != "End")
            {
                load++;
                if (load < 3)
                {
                    dishesCount += Convert.ToInt32(dishes);
                    detergentUsed += Convert.ToInt32(dishes) * 5;                    
                }
                else if (load == 3)
                {
                    potsCount += Convert.ToInt32(dishes);
                    detergentUsed += Convert.ToInt32(dishes) * 15;
                    load = 0;
                }

                if (detergentUsed > detergent)
                {
                    output = $"Not enough detergent, {detergentUsed - detergent} ml. more necessary!";
                    break;
                }

                dishes = Console.ReadLine();
            }

            if (dishes == "End")
            {
                output = $"Detergent was enough!\n{dishesCount} dishes and {potsCount} pots were washed.\nLeftover detergent {detergent - detergentUsed} ml.";
            }

            Console.WriteLine(output);

        }
    }
}

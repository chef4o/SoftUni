using System;

namespace Pokemon
{
    class Program
    {
        static void Main(string[] args)
        {

            uint powerN = uint.Parse(Console.ReadLine());
            uint distanceM = uint.Parse(Console.ReadLine());
            byte exhaustionY = byte.Parse(Console.ReadLine());

            double tempPower = powerN * 0.5;
            int targets = 0;
            while (powerN >= distanceM)
            {
                powerN -= distanceM;
                targets++;

                if (powerN == tempPower && exhaustionY != 0)
                {
                    powerN /= exhaustionY;
                }
            }

            Console.WriteLine($"{powerN}\n{targets}");
        }
    }
}

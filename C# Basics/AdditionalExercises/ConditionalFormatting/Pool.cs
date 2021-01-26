using System;

namespace Pool
{
    class Program
    {
        static void Main(string[] args)
        {
            double poolVolume = double.Parse(Console.ReadLine());
            double pipe1debit = double.Parse(Console.ReadLine());
            double pipe2debit = double.Parse(Console.ReadLine());
            double hoursBreak = double.Parse(Console.ReadLine());

            double waterVolume = hoursBreak * (pipe1debit + pipe2debit);

            if (waterVolume <= poolVolume)
            {
                double fillPercentage = waterVolume / poolVolume * 100;
                double pipe1Percenage = (pipe1debit * hoursBreak) / waterVolume * 100;
                double pipe2Percenage = (pipe2debit * hoursBreak) / waterVolume * 100;

                Console.WriteLine($"The pool is {fillPercentage:f2}% full. Pipe 1: {pipe1Percenage:f2}%. Pipe 2: {pipe2Percenage:f2}%.");
            }
            else
            {
                double overflow = waterVolume - poolVolume;

                Console.WriteLine($"For {hoursBreak:f2} hours the pool overflows with {overflow:f2} liters.");
            }
        }
    }
}

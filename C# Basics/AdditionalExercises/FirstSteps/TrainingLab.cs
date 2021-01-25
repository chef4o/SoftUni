using System;

namespace TrainingLab
{
    class Program
    {
        static void Main(string[] args)
        {
            double lenght = double.Parse(Console.ReadLine());
            double width = double.Parse(Console.ReadLine());

            double availablelenghtCm = lenght * 100;
            double availablewidthCm = (width * 100) - 100;

            double desksPerLenght = Math.Floor(availablelenghtCm / 120);
            double desksPerWidth = Math.Floor(availablewidthCm / 70);

            int desksNumber = Convert.ToInt32((desksPerLenght * desksPerWidth) - 3);

            Console.WriteLine(desksNumber);


        }
    }
}

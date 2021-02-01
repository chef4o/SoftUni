using System;

namespace WeddingSeats
{
    class Program
    {
        static void Main(string[] args)
        {
            char lastSector = char.Parse(Console.ReadLine());
            int Sector1RowsCount = int.Parse(Console.ReadLine());
            int oddRowSeats = int.Parse(Console.ReadLine());

            int rows = Sector1RowsCount;
            int totalPlaces = 0;


            for (char sector = 'A'; sector <= lastSector; sector++)
            {                
                for (int row = 1; row <= rows; row++)
                {
                    int seatsCount = 0;

                    if (row % 2 != 0)
                    {
                        seatsCount = oddRowSeats;
                    }
                    else
                    {
                        seatsCount = oddRowSeats + 2;
                    }

                    int seats = 1;
                    for (char seat  = 'a';  seats <= seatsCount; seat++)
                    {
                        Console.WriteLine($"{sector}{row}{seat}");
                        seats++;
                        totalPlaces++;
                    }

                }

                rows++;

            }

            Console.WriteLine(totalPlaces);
        }
    }
}

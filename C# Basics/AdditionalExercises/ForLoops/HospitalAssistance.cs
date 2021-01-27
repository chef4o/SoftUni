using System;

namespace HospitalAssistance
{
    class Program
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());

            int treatedPatients = 0;
            int untreatedPatients = 0;
            int doctors = 7;

            for (int i = 1; i <= days; i++)
            {
                if (i % 3 == 0 && untreatedPatients > treatedPatients)
                {
                    doctors += 1;
                }

                int patientsPerDay = int.Parse(Console.ReadLine());

                    if (doctors >= patientsPerDay)
                    {
                        treatedPatients += patientsPerDay;
                    }
                    else
                    {
                        treatedPatients += doctors;
                        untreatedPatients += (patientsPerDay - doctors);
                    }

            }

            Console.WriteLine($"Treated patients: {treatedPatients}.\nUntreated patients: {untreatedPatients}.");

        }
    }
}

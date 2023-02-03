using System.Collections.Generic;

namespace BubbleSort.App
{
    public class BubbleSort
    {
        private readonly int[] _listNumeros;

        public BubbleSort()
        {
            _listNumeros = BuildNumbers().ToArray();
        }

        public int[] OrdenaNumeros()
        {
            for (int write = 0; write < _listNumeros.ToArray().Length; write++)
            {
                for (int sort = 0; sort < _listNumeros.ToArray().Length - 1; sort++)
                {
                    if (_listNumeros[sort] > _listNumeros[sort + 1])
                    {
                        (_listNumeros[sort], _listNumeros[sort + 1]) = (_listNumeros[sort + 1], _listNumeros[sort]);
                    }
                }
                ShowResults(_listNumeros);
            }
            return _listNumeros;
        }

        public static int MenorNumero(bool escolha, List<int> numeros)
        {
            switch (escolha)
            {
                //METODO NUTELLA
                case true:
                    numeros.Sort();

                    foreach (var item in numeros)
                    {
                        return item;
                    }
                    return 0;

                //METODO RAIZ
                case false:
                    for (int write = 0; write < numeros.ToArray().Length; write++)
                    {
                        for (int sort = 0; sort < numeros.ToArray().Length - 1; sort++)
                        {
                            if (numeros[sort] > numeros[sort + 1])
                            {
                                (numeros[sort], numeros[sort + 1]) = (numeros[sort + 1], numeros[sort]);
                            }
                        }
                    }
                    return numeros[0];
            }
        }

        public static void ShowResults(int[] numeros)
        {
            Console.Clear();
            foreach (var item in numeros)
            {
                for (int i = 0; i < item; i++)
                {
                    Console.Write(".");
                }

                //TODO: remover apos teste
                Console.WriteLine(item);
            }
            Thread.Sleep(250);
        }

        private static List<int> BuildNumbers()
        {
            int limit = 0;
            int count = 40;

            List<int> numberList = new();
            var random = new Random();

            while (limit < count)
            {
                numberList.Add(random.Next(1, count));
                limit++;
            }

            return numberList.DistinctBy(x => x).ToList();
        }
    }
}
namespace Queue
{
    public class Fifo
    {
        private readonly string[] _names =
        {
            "Ronald",
            "Jailson Mendes",
            "Jhonson",
            "Mary Jane",
            "Petter",
            "Harry"
        };

        public void StartFifo()
        {
            for (int i = 0; i < _names.Length; i++)
            {
                Console.WriteLine(_names[i]);
            }
        }

        public void StartFilo()
        {
            for (int i = _names.Length; i > 0; i--)
            {
                Console.WriteLine(_names[i-1]);
            }
        }
    }
}

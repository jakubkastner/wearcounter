package cz.jkastner.wearcounter;

/**
 * Counter
 */
public class Counter {
    private int count;

    /**
     * Init current count
     */
    private void Counter()
    {
        count = 0;
    }

    /**
     * current count + 1
     * @return true if successfully counted, false if failed
     */
    public boolean addNumber()
    {
        // check maximum of int
        if (count == Integer.MAX_VALUE)
        {
            return false;
        }
        count++;
        return true;
    }

    /**
     * Returns current count as string
     * @return current count
     */
    public String getNumber()
    {
        return Integer.toString(count);
    }

    /**
     * Set current count to 0
     */
    public void reset()
    {
        count = 0;
    }
}

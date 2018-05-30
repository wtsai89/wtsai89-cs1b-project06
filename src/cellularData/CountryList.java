package cellularData;

/**
 * Organizes multiple countries into a linked list
 */
public class CountryList {
    private CountryNode head, walker;
    private int size;

    /**
     * initializes an empty list
     */
    public CountryList()
    {
        head = null;
        size = 0;
    }

    /**
     * copy constructor
     * @param list
     */
    public CountryList(CountryList list)
    {
        head = new CountryNode(list.getHead());
        this.size = list.size();
    }

    /**
     * accessor method for head
     * @return
     */
    public CountryNode getHead() { return head; }

    /**
     * add a node to the end of the list
     * @param country
     */
    public void add(Country country)
    {
        CountryNode node = new CountryNode(country);

        if(head == null)
        {
            head = node;
        }
        else
        {
            walker = head;
            while(walker.getNext() != null)
                walker = walker.getNext();
            walker.setNext(node);
        }

        size++;
    }

    /**
     * returns the country at the specified index
     * @param index
     * @return
     */
    public Country getIndex(int index)
    {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        walker = head;
        for(int i = 0; i < index; i++)
        {
            walker = walker.getNext();
        }

        return walker.getCountry();
    }

    /**
     * checks if the list contains a country and returns that country. Otherwise return null
     * @param country
     * @return
     */
    public Country contains(Country country)
    {
        walker = head;
        Country foundCountry;
        for(int i = 0; i < size; i++)
        {
            foundCountry = walker.getCountry();
            if(foundCountry.equals(country))
                return foundCountry;
            walker = walker.getNext();
        }

        return null;
    }

    /**
     * overrides Object class
     * @return
     */
    public String toString()
    {
        String s = "";
        walker = head;
        for(int i = 0; i < size; i++)
        {
            s += walker.getCountry();
            walker = walker.getNext();
        }

        return s;
    }

    /**
     * getter method for size
     * @return
     */
    public int size()
    {
        return size;
    }

    /**
     * adds a country to the list at the specified index
     * @param country
     * @param index
     */
    public void insertAtIndex(Country country, int index)
    {
        if(index < 0)
            throw new IndexOutOfBoundsException();
        if(index >= size)   //add to end. If size = 0 then it will default to this
        {
            add(country);
        }
        else
        {
            if(index == 0)  //add to beginning
            {
                head = new CountryNode(country, head);
            }
            else //add to middle
            {
                CountryNode before = head;
                CountryNode after = head.getNext();
                for(int i = 1; i < index; i++)
                {
                    before = after;
                    after = after.getNext();
                }
                CountryNode node = new CountryNode(country, after);
                before.setNext(node);
            }
            size++;
        }
    }

    /**
     * replaces a CountryNode at a specified index in the list
     * @param index
     * @param replacement
     */
    public void replaceAtIndex(int index, Country replacement)
    {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        walker = head;
        for(int i = 0; i < index; i++)
        {
            walker = walker.getNext();
        }
        walker.setCountry(replacement);
    }
}

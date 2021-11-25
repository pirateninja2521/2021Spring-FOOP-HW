
public class Card implements Comparable<Card>{
    public String rank;
    public char suit;
    public String str;
    
    public Card(String input) {
        this.suit = input.charAt(0);
        int start = input.indexOf("[")+1;
        int end = input.indexOf("]");
        this.rank = input.substring(start, end);
        this.str = this.suit + "[" + this.rank + "]";
    }

    @Override
    public String toString() {
        return this.str;
    }

    public int getRankNum(){
        if (this.rank.equals("2")) return 12;
        if (this.rank.equals("A")) return 11;
        if (this.rank.equals("K")) return 10;
        if (this.rank.equals("Q")) return 9;
        if (this.rank.equals("J")) return 8;
        if (this.rank.equals("10")) return 7;
        if (this.rank.equals("9")) return 6;
        if (this.rank.equals("8")) return 5;
        if (this.rank.equals("7")) return 4;
        if (this.rank.equals("6")) return 3;
        if (this.rank.equals("5")) return 2;
        if (this.rank.equals("4")) return 1;
        if (this.rank.equals("3")) return 0;
        return -1;
    }

    public int getSuitNum(){
        if (this.suit == 'S') return 3;
        if (this.suit == 'H') return 2;
        if (this.suit == 'D') return 1;
        if (this.suit == 'C') return 0;
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Card))
            return false;
        Card card = (Card) o;
            return card.str.equals(str);
    }

    @Override
    public int compareTo(Card card) {
        if (this.getRankNum() > card.getRankNum()) return 1;
        if (this.getRankNum() < card.getRankNum()) return -1;
        if (this.getSuitNum() > card.getSuitNum()) return 1;
        if (this.getSuitNum() < card.getSuitNum()) return -1;
        return 0;
    }
}

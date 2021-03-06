
class Main {
    void main() {
        Queue q = new Queue();
        q.add("Hello");
        q.add("World");

        Iterator i = q.iterator();
        while (i.hasNext()) {
            println(i.next());
        }
    }
}

class Queue {
    Link first;
    Link last;

    void add(Object value) {
        if (last == null) {
            first = last = new Link(value);
        } else {
            last.next = new Link(value);
            last = last.next;
        }
    }

    Object remove() {
        if (first == null) {
            return null;
        }
        Object value = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return value;
    }

    Iterator iterator() {
        return new Iterator(first);
    }
}

class Iterator {
    Link current;

    Iterator(Link start) {
        current = start;
    }

    boolean hasNext() {
        return current != null;
    }

    Object next() {
        Object value = current.value;
        current = current.next;
        return value;
    }
}

class Link {
    Link next;
    Object value;

    Link(Object value) {
        this.value = value;
    }
}
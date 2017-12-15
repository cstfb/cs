package com.cs.hadoop.essentialhadoop.customewritable;

// cc TextPair A Writable implementation that stores a pair of Text objects
// cc TextPairComparator A RawComparator for comparing TextPair byte representations
// cc TextPairFirstComparator A custom RawComparator for comparing the first field of TextPair byte representations
// vv TextPair
import java.io.*;

import org.apache.hadoop.io.*;

public class TextPair implements WritableComparable<TextPair> {

    private Text first;
    private Text second;

    public TextPair() {
        set(new Text(), new Text());
    }

    public TextPair(String first, String second) {
        set(new Text(first), new Text(second));
    }

    public TextPair(Text first, Text second) {
        set(first, second);
    }

    public void set(Text first, Text second) {
        this.first = first;
        this.second = second;
    }

    public Text getFirst() {
        return first;
    }

    public Text getSecond() {
        return second;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        first.write(out);
        second.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        first.readFields(in);
        second.readFields(in);
    }

    @Override
    public int hashCode() {
        return first.hashCode() * 163 + second.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TextPair) {
            TextPair tp = (TextPair) o;
            return first.equals(tp.first) && second.equals(tp.second);
        }
        return false;
    }

    @Override
    public String toString() {
        return first + "\t" + second;
    }

    @Override
    public int compareTo(TextPair tp) {
        int cmp = first.compareTo(tp.first);
        if (cmp != 0) {
            return cmp;
        }
        return second.compareTo(tp.second);
    }
    // ^^ TextPair

    // vv TextPairComparator
    public static class Comparator extends WritableComparator {

        private static final Text.Comparator TEXT_COMPARATOR = new Text.Comparator();

        public Comparator() {
            super(TextPair.class);
        }

        @Override
        public int compare(byte[] b1, int s1, int l1,
                           byte[] b2, int s2, int l2) {

            try {
                //将两个Text对象分开
                /*
                  Text的序列化方式为：
                    public void write(DataOutput out) throws IOException {
                        // 首先写入长度, 注意这个长度写入到流的时候不是定长的，而是变长的,有利于压缩  --》 length
                        WritableUtils.writeVInt(out, length);
                        // 然后写入数据
                        out.write(bytes, 0, length);
                    }

                  然后读取第一个Text的长度(firstL1 - sizeof(length))的时候直接读取Text序列化之后的length即可:
                  这里有 : firstL1(Text序列化的长度) = length字段的长度 + 字符串的长度
                  length的长度有zero_compressed编码方式决定， 可以使用WritableUtils直接读取
                  字符串的长度极为length的值 , 即为 readVInt
                 */
                int firstL1 = WritableUtils.decodeVIntSize(b1[s1]) + readVInt(b1, s1);
                int firstL2 = WritableUtils.decodeVIntSize(b2[s2]) + readVInt(b2, s2);
                int cmp = TEXT_COMPARATOR.compare(b1, s1, firstL1, b2, s2, firstL2);
                if (cmp != 0) {
                    return cmp;
                }
                return TEXT_COMPARATOR.compare(b1, s1 + firstL1, l1 - firstL1,
                        b2, s2 + firstL2, l2 - firstL2);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    /** Register an optimized comparator for a {@link WritableComparable}
     * implementation. Comparators registered with this method must be
     * thread-safe. */
    static {
        WritableComparator.define(TextPair.class, new Comparator());
    }
    // ^^ TextPairComparator

    // vv TextPairFirstComparator
    public static class FirstComparator extends WritableComparator {

        private static final Text.Comparator TEXT_COMPARATOR = new Text.Comparator();

        public FirstComparator() {
            super(TextPair.class);
        }

        @Override
        public int compare(byte[] b1, int s1, int l1,
                           byte[] b2, int s2, int l2) {

            try {
                int firstL1 = WritableUtils.decodeVIntSize(b1[s1]) + readVInt(b1, s1);
                int firstL2 = WritableUtils.decodeVIntSize(b2[s2]) + readVInt(b2, s2);
                return TEXT_COMPARATOR.compare(b1, s1, firstL1, b2, s2, firstL2);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override
        public int compare(WritableComparable a, WritableComparable b) {
            if (a instanceof TextPair && b instanceof TextPair) {
                return ((TextPair) a).first.compareTo(((TextPair) b).first);
            }
            return super.compare(a, b);
        }
    }
    // ^^ TextPairFirstComparator

// vv TextPair
}
// ^^ TextPair
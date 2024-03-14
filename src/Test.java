public class Test {

    // Copyright (C) emilybache, Inc. All right reserved.
// https://github.com/emilybache/GildedRose-Refactoring-Kata

    class Item {
        public String name; //이름
        public int sellIn; //판매기한
        public int quality; //가격

        public Item(String name, int sellIn, int quality) {
            this.name = name;
            this.sellIn = sellIn;
            this.quality = quality;
        }

        @Override
        public String toString() {
            return this.name + ", " + this.sellIn + ", " + this.quality;
        }
    }

    class GildedRose {
        Item[] items;

        public GildedRose(Item[] items) {
            this.items = items;
        }

        public void updateQuality() {
            for (int i = 0; i < items.length; i++) {

                //만약 Aged Brie, Backstage Passed이 아닌 다른 아이템이라면
                if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                    //가격이 존재할때만, 가격을 1 낮춘다. (단, Sulfuras 제외)
                    if (items[i].quality > 0) {
                        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                            items[i].quality = items[i].quality - 1;
                            //모든 아이템들은 가격이 달라진다.
                        }
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;

                        //콘서트 티켓은 판매 기한이 0에 수렴할 수록 가격이 증가한다.
                        if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            //판매기한이 10 이하일때는 가격이 1씩 증가한다.
                            if (items[i].sellIn < 11) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }

                            //판매기한이 5 이하일때는 가격이 1씩 더 증가한다.
                            if (items[i].sellIn < 6) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }

                                //아이템 가격은 50 이상일때는 아무것도 하지 않는다.
                            }
                        }
                    }
                }

                //=================버그 발생 방지===============================
                //Sulfuras 아이템이 아닐 경우에는 판매기한(sellin)을 1 줄인다. by inho.choi
                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].sellIn = items[i].sellIn - 1;
                }
                //============================================================

                //판매기한이 음수일때 처리
                if (items[i].sellIn < 0) {
                    if (!items[i].name.equals("Aged Brie")) {
                        if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (items[i].quality > 0) {
                                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                    items[i].quality = items[i].quality - 1;
                                }
                            }
                        } else {
                            items[i].quality = items[i].quality - items[i].quality;
                        }
                    }
                }
            }
        }
    }

}
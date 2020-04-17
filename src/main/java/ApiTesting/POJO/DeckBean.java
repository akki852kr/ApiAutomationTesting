package ApiTesting.POJO;

public class DeckBean {

        private String deckId;

        public DeckBean() {
        }

        public  DeckBean(String deckId) {
            this.deckId = deckId;
        }

        public String getDeckId() {
            return deckId;
        }

        public void setDeckId(String deckId) {
            this.deckId = deckId;
        }

        @Override
        public String toString() {
            return "DeckBean{" +
                    "deckId='" + deckId + '\'' +
                    '}';
        }
    }


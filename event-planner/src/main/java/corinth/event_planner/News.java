package corinth.event_planner;

public class News {
    public class Story {
        private String id;
        private String webTitle;
        private String webUrl;

        /**
         * Accessor method for id.
         * @return String The id for the article.
         */
        public String getId() {
            return this.id;
        }

        /**
         * Accessor method for the web title.
         * @return String The title for the website article.
         */
        public String getWebTitle() {
            return this.webTitle;
        }

        /**
         * Accessor method for the web url.
         * @return String The title for the web url for the story.
         */
        public String getWebUrl() {
            return this.webUrl;
        }
    }
    private Story results[];

    /**
     * Accessor method the {@code results} array.
     * @return Story[] Array that stores all of the articles.
     */
    public Story[] getResults() {
        return this.results;
    }
}

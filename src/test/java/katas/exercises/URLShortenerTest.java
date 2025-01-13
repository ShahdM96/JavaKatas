package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class URLShortenerTest {

    @Test
    void testShortenAndRetrieve() {
        URLShortener shortener = new URLShortener();

        String longUrl = "https://www.example.com/some/really/long/url";
        String shortUrl = shortener.shorten(longUrl);

        assertNotNull(shortUrl, "Shortened URL should not be null");
        assertTrue(shortUrl.startsWith("http://short.ly/"), "Shortened URL should start with the base URL");

        String retrievedUrl = shortener.retrieve(shortUrl);
        assertEquals(longUrl, retrievedUrl, "Retrieved URL should match the original long URL");
    }


    @Test
    void testShortenSameURL() {
        URLShortener shortener = new URLShortener();

        String longUrl = "https://www.example.com/some/really/long/url";
        String shortUrl1 = shortener.shorten(longUrl);
        String shortUrl2 = shortener.shorten(longUrl);

        assertEquals(shortUrl1, shortUrl2);
    }


    @Test
    void testRetrieveInvalidShortUrl() {
        URLShortener urlShortener = new URLShortener();

        String invalidShortUrl = "http://short.ly/invalid";
        String retrievedUrl = urlShortener.retrieve(invalidShortUrl);

        assertNull(retrievedUrl, "Should return null");
    }
}
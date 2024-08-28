package com.example.githubapi.Services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepositoryServiceImpl implements RepositoryService {

    @Override
    public String getTopContributorsByLink(String repositoryLink) {
        StringBuilder result = new StringBuilder();
        StringBuilder contributorsList = new StringBuilder();

        try {
            // Contributors sayfasına git
            Document doc = Jsoup.connect(repositoryLink + "/graphs/contributors").get();

            // Katkı sahiplerini data-hovercard-type="user" ve text-normal classından bul
            Elements contributorLinks = doc.select("a[data-hovercard-type=user].text-normal");

            // Sayfada bulunamayan class isimleri veya selector'lar için bir log mesajı ekleyelim
            System.out.println("Number of contributor links found: " + contributorLinks.size());

            if (contributorLinks.isEmpty()) {
                result.append("Katkıda bulunan kişiler bulunamadı.");
            } else {
                // İlk 5 katkı sahibini al
                List<String> topContributors = contributorLinks.stream()
                        .limit(5)
                        .map(e -> e.attr("href").replace("/", ""))  // href içinden kullanıcı adını çıkarıyoruz
                        .collect(Collectors.toList());

                // Repository adı
                String repoName = repositoryLink.replace("https://github.com/", "").replace("/", "_");
                result.append("Repository: ").append(repoName).append("\n\n");

                // Katkı sahiplerinin isimlerini string'e ekle
                result.append("Top Contributors:\n");
                int count = 1;
                for (String contributor : topContributors) {
                    result.append(count).append("- Username: ").append(contributor).append("\n");
                    contributorsList.append(contributor).append(" ");  // Kullanıcı adlarını tek bir stringde topluyoruz
                    count++;
                }

                // Sonuçları dosyaya kaydet
                saveResultToFile(result.toString(), repoName);

                // Toplanmış tüm kullanıcı adlarını ekrana bastır
                System.out.println("Contributors List: " + contributorsList.toString());
            }
        } catch (IOException e) {
            result.append("Hata oluştu: ").append(e.getMessage());
        }

        return result.toString();
    }

    private void saveResultToFile(String result, String repoName) throws IOException {
        String filePath = "src/main/java/com/example/githubapi/Results/" + repoName + "_contributors.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(result);
        }
    }
}

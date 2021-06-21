import java.util.Arrays;
import java.util.List;

public class Metadata {
    public String fileName;
    public String title;
    public String journalTitle;
    public Integer year;
    public List<String> creators;
    public String location;
    public String publicationTitle;
    public int beginPage;
    public int endPage;
    public int volume;
    public String issue;
    public String journalNote;
    public MetadataSource metadataSource;
    public int ppn;
    public String languages;
    public String keywords;


    public void setPageNumbers(List<Integer> pageNumbers) {
        if (pageNumbers.size()>1) {
            this.beginPage = pageNumbers.get(0);
            this.endPage = pageNumbers.get(pageNumbers.size() - 1);
        }
    }


    @Override
    public String toString() {
        StringBuilder repr = new StringBuilder();
        for (Object obj : Arrays.asList(title, String.join(", ", creators),publicationTitle,location, journalTitle, year, beginPage + "-" + endPage)) {
            repr.append(obj);
            repr.append("\n\t");
        }
        return repr.toString();
    }


    public int getExtent(){
        return endPage- beginPage;
    }

    public String getPages(){
        int pages = getExtent();
        return String.valueOf(pages);
    }
}
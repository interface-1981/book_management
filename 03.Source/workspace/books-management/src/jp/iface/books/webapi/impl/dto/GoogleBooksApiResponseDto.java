package jp.iface.books.webapi.impl.dto;

import java.util.List;

public class GoogleBooksApiResponseDto {

	private String kind;
	private int totalItems;
	private List<Item> items;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public class Item{

		private String kind;
		private String id;
		private String etag;
		private String selfLink;
		private VolumeInfo volumeInfo;
		private SaleInfo saleInfo;
		private AccessInfo accessInfo;
		private SearchInfo searchInfo;

		public String getKind() {
			return kind;
		}

		public void setKind(String kind) {
			this.kind = kind;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getEtag() {
			return etag;
		}

		public void setEtag(String etag) {
			this.etag = etag;
		}

		public String getSelfLink() {
			return selfLink;
		}

		public void setSelfLink(String selfLink) {
			this.selfLink = selfLink;
		}

		public VolumeInfo getVolumeInfo() {
			return volumeInfo;
		}

		public void setVolumeInfo(VolumeInfo volumeInfo) {
			this.volumeInfo = volumeInfo;
		}

		public SaleInfo getSaleInfo() {
			return saleInfo;
		}

		public void setSaleInfo(SaleInfo saleInfo) {
			this.saleInfo = saleInfo;
		}

		public AccessInfo getAccessInfo() {
			return accessInfo;
		}

		public void setAccessInfo(AccessInfo accessInfo) {
			this.accessInfo = accessInfo;
		}

		public SearchInfo getSearchInfo() {
			return searchInfo;
		}

		public void setSearchInfo(SearchInfo searchInfo) {
			this.searchInfo = searchInfo;
		}

		public class VolumeInfo {

			private String title;
			private String subtitle;
			private List<String> authors;
			private String publishedDate;
			private String publisher;
			private String description;
			private List<IndustryIdentifier> industryIdentifiers;
			private ReadingModes readingModes;
			private int pageCount;
			private String printType;
			private String maturityRating;
			private boolean allowAnonLogging;
			private String contentVersion;
			private ImageLinks imageLinks;
			private String language;
			private String previewLink;
			private String infoLink;
			private String canonicalVolumeLink;


			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getSubtitle() {
				return subtitle;
			}

			public void setSubtitle(String subtitle) {
				this.subtitle = subtitle;
			}

			public List<String> getAuthors() {
				return authors;
			}

			public void setAuthors(List<String> authors) {
				this.authors = authors;
			}

			public String getPublishedDate() {
				return publishedDate;
			}

			public String getPublisher() {
				return publisher;
			}

			public void setPublisher(String publisher) {
				this.publisher = publisher;
			}

			public void setPublishedDate(String publishedDate) {
				this.publishedDate = publishedDate;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public List<IndustryIdentifier> getIndustryIdentifiers() {
				return industryIdentifiers;
			}

			public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
				this.industryIdentifiers = industryIdentifiers;
			}

			public ReadingModes getReadingModes() {
				return readingModes;
			}

			public void setReadingModes(ReadingModes readingModes) {
				this.readingModes = readingModes;
			}

			public int getPageCount() {
				return pageCount;
			}

			public void setPageCount(int pageCount) {
				this.pageCount = pageCount;
			}

			public String getPrintType() {
				return printType;
			}

			public void setPrintType(String printType) {
				this.printType = printType;
			}

			public String getMaturityRating() {
				return maturityRating;
			}

			public void setMaturityRating(String maturityRating) {
				this.maturityRating = maturityRating;
			}

			public boolean isAllowAnonLogging() {
				return allowAnonLogging;
			}

			public void setAllowAnonLogging(boolean allowAnonLogging) {
				this.allowAnonLogging = allowAnonLogging;
			}

			public String getContentVersion() {
				return contentVersion;
			}

			public void setContentVersion(String contentVersion) {
				this.contentVersion = contentVersion;
			}

			public ImageLinks getImageLinks() {
				return imageLinks;
			}

			public void setImageLinks(ImageLinks imageLinks) {
				this.imageLinks = imageLinks;
			}

			public String getLanguage() {
				return language;
			}

			public void setLanguage(String language) {
				this.language = language;
			}

			public String getPreviewLink() {
				return previewLink;
			}

			public void setPreviewLink(String previewLink) {
				this.previewLink = previewLink;
			}

			public String getInfoLink() {
				return infoLink;
			}

			public void setInfoLink(String infoLink) {
				this.infoLink = infoLink;
			}

			public String getCanonicalVolumeLink() {
				return canonicalVolumeLink;
			}

			public void setCanonicalVolumeLink(String canonicalVolumeLink) {
				this.canonicalVolumeLink = canonicalVolumeLink;
			}

			public class IndustryIdentifier {

				private String type;
				private String identifier;

				public String getType() {
					return type;
				}
				public void setType(String type) {
					this.type = type;
				}
				public String getIdentifier() {
					return identifier;
				}
				public void setIdentifier(String identifier) {
					this.identifier = identifier;
				}

			}

			public class ReadingModes {

				private boolean text;
				private boolean image;

				public boolean isText() {
					return text;
				}
				public void setText(boolean text) {
					this.text = text;
				}
				public boolean isImage() {
					return image;
				}
				public void setImage(boolean image) {
					this.image = image;
				}

			}

			public class ImageLinks {

				private String smallThumbnail;
				private String thumbnail;

				public String getSmallThumbnail() {
					return smallThumbnail;
				}
				public void setSmallThumbnail(String smallThumbnail) {
					this.smallThumbnail = smallThumbnail;
				}
				public String getThumbnail() {
					return thumbnail;
				}
				public void setThumbnail(String thumbnail) {
					this.thumbnail = thumbnail;
				}

			}
		}

		public class SaleInfo {

			private String country;
			private String saleability;
			private boolean isEbook;

			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public String getSaleability() {
				return saleability;
			}
			public void setSaleability(String saleability) {
				this.saleability = saleability;
			}
			public boolean isEbook() {
				return isEbook;
			}
			public void setEbook(boolean isEbook) {
				this.isEbook = isEbook;
			}

		}

		public class AccessInfo {

			private String country;
			private String viewability;
			private boolean embeddable;
			private boolean publicDomain;
			private String textToSpeechPermission;
			private Epub epub;
			private PDF pdf;
			private String webReaderLink;
			private String accessViewStatus;
			private boolean quoteSharingAllowed;

			public String getCountry() {
				return country;
			}

			public void setCountry(String country) {
				this.country = country;
			}

			public String getViewability() {
				return viewability;
			}

			public void setViewability(String viewability) {
				this.viewability = viewability;
			}

			public boolean isEmbeddable() {
				return embeddable;
			}

			public void setEmbeddable(boolean embeddable) {
				this.embeddable = embeddable;
			}

			public boolean isPublicDomain() {
				return publicDomain;
			}

			public void setPublicDomain(boolean publicDomain) {
				this.publicDomain = publicDomain;
			}

			public String getTextToSpeechPermission() {
				return textToSpeechPermission;
			}

			public void setTextToSpeechPermission(String textToSpeechPermission) {
				this.textToSpeechPermission = textToSpeechPermission;
			}

			public Epub getEpub() {
				return epub;
			}

			public void setEpub(Epub epub) {
				this.epub = epub;
			}

			public PDF getPdf() {
				return pdf;
			}

			public void setPdf(PDF pdf) {
				this.pdf = pdf;
			}

			public String getWebReaderLink() {
				return webReaderLink;
			}

			public void setWebReaderLink(String webReaderLink) {
				this.webReaderLink = webReaderLink;
			}

			public String getAccessViewStatus() {
				return accessViewStatus;
			}

			public void setAccessViewStatus(String accessViewStatus) {
				this.accessViewStatus = accessViewStatus;
			}

			public boolean isQuoteSharingAllowed() {
				return quoteSharingAllowed;
			}

			public void setQuoteSharingAllowed(boolean quoteSharingAllowed) {
				this.quoteSharingAllowed = quoteSharingAllowed;
			}

			public class Epub {

				private boolean isAvailable;

				public boolean isAvailable() {
					return isAvailable;
				}

				public void setAvailable(boolean isAvailable) {
					this.isAvailable = isAvailable;
				}

			}

			public class PDF {

				private boolean isAvailable;

				public boolean isAvailable() {
					return isAvailable;
				}

				public void setAvailable(boolean isAvailable) {
					this.isAvailable = isAvailable;
				}
			}
		}

		public class SearchInfo {

			private String textSnippet;

			public String getTextSnippet() {
				return textSnippet;
			}

			public void setTextSnippet(String textSnippet) {
				this.textSnippet = textSnippet;
			}
		}
	}

}

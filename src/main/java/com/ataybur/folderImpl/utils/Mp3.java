package com.ataybur.folderImpl.utils;

public class Mp3 {
	
	@MapField(key = "title")
	@ModelField(columnNumber = 0)
	private String title;
	
	@MapField(key = "creator")
	@ModelField(columnNumber = 1)
	private String creator;
	
	@MapField(key = "xmpDM:album")
	@ModelField(columnNumber = 2)
	private String album;
	
	@MapField(key = "xmpDM:trackNumber")
	@ModelField(columnNumber = 3)
	private String trackNumber;
	
	@MapField(key = "xmpDM:releaseDate")
	@ModelField(columnNumber = 4)
	private String releaseDate;
	
	@MapField(key = "meta:author")
	@ModelField(columnNumber = 5)
	private String author;
	
	@MapField(key = "xmpDM:artist")
	@ModelField(columnNumber = 6)
	private String artist;

	
	@MapField(key = "dc:creator")
	@ModelField(columnNumber = 7)
	private String dcCreator;
	
	@MapField(key = "xmpDM:audioCompressor")
	@ModelField(columnNumber = 8)
	private String audioCompressor;
	
	@MapField(key = "xmpDM:genre")
	@ModelField(columnNumber = 9)
	private String genre;
	
	@MapField(key = "xmpDM:audioChannelType")
	@ModelField(columnNumber = 10)
	private String audioChannelType;
	
	@MapField(key = "version")
	@ModelField(columnNumber = 11)
	private String version;
	
	@MapField(key = "xmpDM:logComment")
	@ModelField(columnNumber = 12)
	private String logComment;
	
	@MapField(key = "xmpDM:audioSampleRate")
	@ModelField(columnNumber = 13)
	private String audioSampleRate;
	
	@MapField(key = "channels")
	@ModelField(columnNumber = 14)
	private String channels;
	
	@MapField(key = "dc:title")
	@ModelField(columnNumber = 15)
	private String dcTitle;
	
	@MapField(key = "Author")
	@ModelField(columnNumber = 16)
	private String author2;
	
	@MapField(key = "xmpDM:albumArtist")
	@ModelField(columnNumber = 17)
	private String albumArtist;

	@MapField(key = "xmpDM:duration")
	@ModelField(columnNumber = 18)
	private String duration;
	
	@MapField(key = "Content-Type")
	@ModelField(columnNumber = 19)
	private String contentType;
	
	@MapField(key = "samplerate")
	@ModelField(columnNumber = 20)
	private String samplerate;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDcCreator() {
		return dcCreator;
	}

	public void setDcCreator(String dcCreator) {
		this.dcCreator = dcCreator;
	}

	public String getAudioCompressor() {
		return audioCompressor;
	}

	public void setAudioCompressor(String audioCompressor) {
		this.audioCompressor = audioCompressor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAudioChannelType() {
		return audioChannelType;
	}

	public void setAudioChannelType(String audioChannelType) {
		this.audioChannelType = audioChannelType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLogComment() {
		return logComment;
	}

	public void setLogComment(String logComment) {
		this.logComment = logComment;
	}

	public String getAudioSampleRate() {
		return audioSampleRate;
	}

	public void setAudioSampleRate(String audioSampleRate) {
		this.audioSampleRate = audioSampleRate;
	}

	public String getChannels() {
		return channels;
	}

	public void setChannels(String channels) {
		this.channels = channels;
	}

	public String getDcTitle() {
		return dcTitle;
	}

	public void setDcTitle(String dcTitle) {
		this.dcTitle = dcTitle;
	}

	public String getAuthor2() {
		return author2;
	}

	public void setAuthor2(String author2) {
		this.author2 = author2;
	}

	public String getAlbumArtist() {
		return albumArtist;
	}

	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getSamplerate() {
		return samplerate;
	}

	public void setSamplerate(String samplerate) {
		this.samplerate = samplerate;
	}

	@Override
	public String toString() {
		return "Mp3 [genre=" + genre + ", creator=" + creator + ", album=" + album + ", trackNumber=" + trackNumber
				+ ", releaseDate=" + releaseDate + ", author=" + author + ", artist=" + artist + ", dcCreator="
				+ dcCreator + ", audioCompressor=" + audioCompressor + ", title=" + title + ", audioChannelType="
				+ audioChannelType + ", version=" + version + ", logComment=" + logComment + ", audioSampleRate="
				+ audioSampleRate + ", channels=" + channels + ", dcTitle=" + dcTitle + ", author2=" + author2
				+ ", albumArtist=" + albumArtist + ", duration=" + duration + ", contentType=" + contentType
				+ ", samplerate=" + samplerate + "]";
	}
	
}

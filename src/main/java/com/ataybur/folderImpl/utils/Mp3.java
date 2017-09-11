package com.ataybur.folderImpl.utils;

public class Mp3 {
	@MapField(key = "xmpDM:genre")
	private String genre;
	
	@MapField(key = "creator")
	private String creator;
	
	@MapField(key = "xmpDM:album")
	private String album;
	
	@MapField(key = "xmpDM:trackNumber")
	private String trackNumber;
	
	@MapField(key = "xmpDM:releaseDate")
	private String releaseDate;
	
	@MapField(key = "meta:author")
	private String author;
	
	@MapField(key = "xmpDM:artist")
	private String artist;
	
	@MapField(key = "dc:creator")
	private String dcCreator;
	
	@MapField(key = "xmpDM:audioCompressor")
	private String audioCompressor;
	
	@MapField(key = "title")
	private String title;
	
	@MapField(key = "xmpDM:audioChannelType")
	private String audioChannelType;
	
	@MapField(key = "version")
	private String version;
	
	@MapField(key = "xmpDM:logComment")
	private String logComment;
	
	@MapField(key = "xmpDM:audioSampleRate")
	private String audioSampleRate;
	
	@MapField(key = "channels")
	private String channels;
	
	@MapField(key = "dc:title")
	private String dcTitle;
	
	@MapField(key = "Author")
	private String author2;
	
	@MapField(key = "xmpDM:albumArtist")
	private String albumArtist;

	@MapField(key = "xmpDM:duration")
	private String duration;
	
	@MapField(key = "Content-Type")
	private String contentType;
	
	@MapField(key = "samplerate")
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

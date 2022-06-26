package model;

import java.util.List;

public interface IVideoDAO {

	void crearVideo(Video video);

	void borrarVideo(Video video);

	void modificarVideo(Video video);

	Video getVideo(int id);

	List<Video> getVideos();

}

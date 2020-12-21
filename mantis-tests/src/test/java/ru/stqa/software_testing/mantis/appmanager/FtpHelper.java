package ru.stqa.software_testing.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpHelper {

  private final ApplicationManager app;
  private final FTPClient ftp;

  public FtpHelper(ApplicationManager app) {
    this.app = app;
    ftp = new FTPClient();
  }

  // Загрузка нового конфигурационного файла mantis
  // Старый  файл временно будет переименован
  public void upload(File file, String target, String backup) throws IOException, IOException {
    // Установка соединения
    ftp.connect(app.getProperty("ftp.host"));
    // Вход на FTP-сервер
    ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
    // Удаление предыдущей резервной копии, если таковая есть
    ftp.deleteFile(backup);
    // Переименование оригинального конфигурационного файла в резервный
    ftp.rename(target, backup);
    // Включение пассивного режима передачи файлов
    // Это ограничение тестового FTP-сервера
    ftp.enterLocalPassiveMode();
    // Передача файла
    ftp.storeFile(target, new FileInputStream(file));
    ftp.disconnect();
  }

  // Восстановление старого конфигурационного файла
  public void restore(String backup, String target) throws IOException {
    ftp.connect(app.getProperty("ftp.host"));
    // Вход на FTP-сервер
    ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
    // Удаление файла, который был загружен в upload()
    ftp.deleteFile(target);
    // Переименование резервного файла в оригинальный конфигурационный файл
    ftp.rename(backup, target);
    ftp.disconnect();
  }
}

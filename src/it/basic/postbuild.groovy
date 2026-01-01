import java.util.jar.JarFile

assert new File(basedir, 'target/sample-1.0-SNAPSHOT.jar').exists()

File installed = new File(basedir, '../../local-repo/org/jenkins-ci/its/sample/1.0-SNAPSHOT/')
File f = new File(installed, 'sample-1.0-SNAPSHOT.jar')
assert f.file

return true

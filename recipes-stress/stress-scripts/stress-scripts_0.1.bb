SUMMARY = "Stress scripts used for burning MTK platforms"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://start.py \
           file://disk.py \
           file://runner.py \
           file://read_temp.py \
           file://read_oops.py \
"

S = "${WORKDIR}"

do_install() {
	install -d -m 0755 ${D}${ROOT_HOME}/stress_scripts
	install -m 0755 ${WORKDIR}/start.py ${D}${ROOT_HOME}/stress_scripts/start.py
	install -m 0644 ${WORKDIR}/disk.py ${D}${ROOT_HOME}/stress_scripts/disk.py
	install -m 0644 ${WORKDIR}/runner.py ${D}${ROOT_HOME}/stress_scripts/runner.py
	install -m 0755 ${WORKDIR}/read_temp.py ${D}${ROOT_HOME}/stress_scripts/read_temp.py
	install -m 0755 ${WORKDIR}/read_oops.py ${D}${ROOT_HOME}/stress_scripts/read_oops.py
}

RDEPENDS:${PN} = " \
	iperf3 \
	fio \
	stress-ng \
	glmark2 \
	sysstat \
	gstreamer1.0-plugins-good-video4linux2 \
	gstreamer1.0-plugins-base-playback \
"

RDEPENDS:${PN}:append:i1200 = " \
	neuropilot-bin \
"

FILES:${PN} = " \
	${ROOT_HOME}/stress_scripts/start.py \
	${ROOT_HOME}/stress_scripts/disk.py \
	${ROOT_HOME}/stress_scripts/runner.py \
	${ROOT_HOME}/stress_scripts/read_temp.py \
	${ROOT_HOME}/stress_scripts/read_oops.py \
"

